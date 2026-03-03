/**
 * 무게가 다른 1~n 구슬
 * 중간(무게 순서로 (N+1)/2번째) 구슬 찾기 -> 양팔 저울
 * - M개 쌍의 결과로 부터, 체이닝 가능
 * 
 * 무게가 중간인 구슬이 될 수 없는 구슬의 개수 구하기
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { BooleanArray(n + 1) }
    val adjrev = Array(n + 1) { BooleanArray(n + 1) }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val hi = st.nextToken().toInt()
        val lo = st.nextToken().toInt()
        adj[hi][lo] = true
        adjrev[lo][hi] = true
    }

    fun dfs(start: Int) {
        val visited = BooleanArray(n + 1)

        val stack = ArrayDeque<Int>()
        stack.push(start)

        while (stack.isNotEmpty()) {
            var cur = stack.pop()

            for (nxt in 1..n) {
                if (adj[cur][nxt] && !visited[nxt]) {
                    visited[nxt] = true
                    adj[start][nxt] = true
                    stack.push(nxt)
                }
            }
        }
    }

    (1..n).forEach { dfs(it) }

    fun dfs2(start: Int) {
        val visited = BooleanArray(n + 1)

        val stack = ArrayDeque<Int>()
        stack.push(start)

        while (stack.isNotEmpty()) {
            var cur = stack.pop()

            for (nxt in 1..n) {
                if (adjrev[cur][nxt] && !visited[nxt]) {
                    visited[nxt] = true
                    adjrev[start][nxt] = true
                    stack.push(nxt)
                }
            }
        }
    }
    (1..n).forEach { dfs2(it) }

    var result = mutableSetOf<Int>()
    for (i in 1..n) {
        val cnt = adj[i].filter { it }.count()
        if (cnt >= (n + 1) / 2) result.add(i)
    }

    for (i in 1..n) {
        val cnt = adjrev[i].filter { it }.count()
        if (cnt >= (n + 1) / 2) result.add(i)
    }

    print(result.size)
}