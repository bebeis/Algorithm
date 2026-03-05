/**
 * ASP를 구해야 함
 */

import java.util.*

const val INF = 0x3f3f3f3f

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()    

    val d = Array(n + 1) { IntArray(n + 1) { INF } }
    for (i in 1..n) d[i][i] = 0
    val nxt = Array(n + 1) { IntArray(n + 1) }

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        d[u][v] = minOf(d[u][v], w)
        nxt[u][v] = v
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (d[i][j] > d[i][k] + d[k][j]) {
                    d[i][j] = d[i][k] + d[k][j]
                    nxt[i][j] = nxt[i][k]
                }
            }
        }
    }

    println(d.drop(1).map { line -> line.drop(1).map { if (it == INF) 0 else it }.joinToString(" ") }.joinToString("\n"))

    val sb = StringBuilder()
    for (i in 1..n) {
        for (j in 1..n) {
            if (d[i][j] == 0 || d[i][j] == INF) {
                sb.append("0\n")
                continue
            }

            val path = mutableListOf<Int>()
            var st = i
            while (st != j) {
                path.add(st)
                st = nxt[st][j]
            }
            path.add(st)

            sb.append(path.size).append(' ')
            sb.append(path.joinToString(" "))
            sb.append('\n')
        }
    }
    print(sb)
}