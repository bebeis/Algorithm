import java.util.*

val dx = intArrayOf(1, 0, -1, 0);
val dy = intArrayOf(0, 1, 0, -1);

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    val board = Array(r) { readLine().toCharArray() }

    val df = Array(r) { IntArray(c) { -1 } }
    val dp = Array(r) { IntArray(c) { -1 } }

    val fq = ArrayDeque<Pair<Int, Int>>()
    val pq = ArrayDeque<Pair<Int, Int>>()
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (board[i][j] == 'F') {
                fq.offer(i to j)
                df[i][j] = 0
            } else if (board[i][j] == 'J') {
                pq.offer(i to j)
                dp[i][j] = 0

                if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                    print(1)
                    return@with
                }
            }
        }
    }

    while (fq.isNotEmpty()) {
        val (cx, cy) = fq.poll()

        for (i in 0 until 4) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nx !in 0..r-1 || ny !in 0..c-1) continue
            if (board[nx][ny] == '#') continue
            if (df[nx][ny] != -1) continue
            df[nx][ny] = df[cx][cy] + 1
            fq.offer(nx to ny)
        }
    }

    while (pq.isNotEmpty()) {
        val (cx, cy) = pq.poll()

        for (i in 0 until 4) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nx !in 0..r-1 || ny !in 0..c-1) continue
            if (board[nx][ny] == '#') continue
            if (dp[nx][ny] != -1) continue
            if (df[nx][ny] == -1 || df[nx][ny] > dp[cx][cy] + 1) {
                dp[nx][ny] = dp[cx][cy] + 1
                if (nx == 0 || nx == r - 1 || ny == 0 || ny == c - 1) {
                    print(dp[nx][ny] + 1)
                    return@with
                }
                pq.offer(nx to ny)
            }
        }
    }

    print("IMPOSSIBLE")
}