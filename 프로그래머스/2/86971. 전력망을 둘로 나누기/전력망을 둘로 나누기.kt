/*
두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 되도록 나눔
차이를 return한다
1. 끊을 전선을 하나씩 모두 선택한다
    - 끊어진 두 점중 한 곳을 택하여 완탐을한다.
*/
import java.util.*

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var graph = Array(n + 1) { mutableListOf<Int>() }
        for ((st, ed) in wires) {
            graph[st].add(ed)
            graph[ed].add(st)
        }
        
        var min = 0x3f3f3f3f
        for ((node, disnode) in wires) {
            var cnt = 1
            val queue = ArrayDeque<Int>()
            val visited = BooleanArray(n + 1)
            visited[node] = true
            
            queue.offer(node)
            while (queue.isNotEmpty()) {
                var cur = queue.poll()
                
                for (nxt in graph[cur]) {
                    if (nxt == disnode) continue
                    if (visited[nxt]) continue
                    visited[nxt] = true
                    queue.offer(nxt)
                    cnt++
                }
            }
            val diff = Math.abs(n - 2 * cnt)
            
            min = minOf(min, diff)
        }
        return min
    }
}