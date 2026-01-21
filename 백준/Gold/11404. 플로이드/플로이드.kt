import java.util.*
import kotlin.math.min

const val INF = 0x3f3f3f3f
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()

    val dist = List(n + 1) { IntArray(n + 1) { INF } }
    for (i in 1..n) {
        dist[i][i] = 0
    }

    repeat(m) {
        with(StringTokenizer(readLine())) {
            val (a, b, c) = listOf(nextToken().toInt(), nextToken().toInt(), nextToken().toInt())
            dist[a][b] = min(dist[a][b], c)
        }
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    val sb = StringBuilder()
    for (i in 1..n) {
        for (j in 1..n) {
            sb.append(if (dist[i][j] == INF) 0 else dist[i][j]).append(' ')
        }
        sb.append('\n')
    }

    print(sb)
}
