/**
 * N개의 마을 중 몇 개의 마을을 '우수 마을'로 선정
 * - '우수 마을'로 선정된 마을 주민 수의 총 합을 최대
 * - '우수 마을'끼리는 서로 인접해 있을 수 없다.
 * - '우수 마을'로 선정되지 못한 마을은 적어도 하나의 '우수 마을'과는 인접해 있어야 한다.
 * 
 * '우수 마을'의 주민 수의 총 합은?
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }
    val adj = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        adj[u].add(v)
        adj[v].add(u)
    }

    val d = Array(n + 1) { IntArray(2) { -1 } }

    fun dp(cur: Int, before: Int, use: Int): Int {
        if (d[cur][use] != -1) return d[cur][use]

        d[cur][use] = 0
        for (nxt in adj[cur]) {
            if (nxt == before) continue
            if (use == 1) {
                d[cur][1] += dp(nxt, cur, 0)
            } else {
                d[cur][0] += maxOf(dp(nxt, cur, 1), dp(nxt, cur, 0))
            }
        }

        if (use == 1) d[cur][1] += arr[cur - 1]
        return d[cur][use]
    }

    dp(1, 0, 0)
    dp(1, 0, 1)
    print(maxOf(d[1][1], d[1][0]))
}