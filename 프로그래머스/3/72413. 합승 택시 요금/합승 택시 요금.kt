import java.util.*
/*
1. 처음부터 따로 출발
2. 같이가다가 중간에 분리
결론: D[교차->A] + D[교차->B] + D[S->교차점]
*/
const val INF = 0x3f3f3f3f

class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val d = Array(n + 1) { IntArray(n + 1) {INF} }
        for ((st, ed, w) in fares) {
            d[st][ed] = w
            d[ed][st] = w
        }
        
        for (i in 1..n) d[i][i] = 0
        
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j]
                    }
                }
            }
        }
        
        var min = Integer.MAX_VALUE
        for (mid in 1..n) {
            if (d[s][mid] == INF || d[mid][a] == INF || d[mid][b] == INF) continue
            min = minOf(min, d[s][mid] + d[mid][a] + d[mid][b])
        }
        
        return min
    }
}