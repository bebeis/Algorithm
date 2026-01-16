import java.util.ArrayDeque
import java.util.Queue
import kotlin.math.min

/**
 * 문제: 출발점에서 도착지까지 최단 이동 거리 구하기
 * - 조건: 벽을 1회 부술 수 있다.
 * - n, m <= 1000
 * 각 벽을 부수는 경우에 대해서는 시간이 부족함
 * 접근: 상태를 가지고 이동해보자.
 * 벽을 부셨는지, 안부셨는지를 기록하면서 이동한다.
 * 상수배 연산이 늘어나므로, 시간 복잡도상 괜찮음
 */

val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)
const val INF = 0x3f3f3f3f
const val MAX_BREAK_COUNT = 1

fun main() = with(System.`in`.bufferedReader()) {
    val (rows, cols) = readLine().split(" ").map { it.toInt() }

    val road = Array(rows) { IntArray(cols) }
    for (i in 0 until rows) {
        readLine().toCharArray()
            .map { it - '0' }
            .forEachIndexed { idx, x -> road[i][idx] = x }
    }

    // 상태 저장
    val dist = Array(rows) { Array(cols) { IntArray(2) { INF } } }
    val queue: Queue<Triple<Int, Int, Int>> = ArrayDeque()

    dist[0][0][0] = 1
    queue.offer(Triple(0, 0, 0))

    while (queue.isNotEmpty()) {
        val (cx, cy, count) = queue.poll()

        for (i in 0 until 4) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) continue;

            if (count < MAX_BREAK_COUNT) {
                // 벽 뚫는 경우
                if (road[nx][ny] == 1 && dist[nx][ny][1] == INF) {
                    dist[nx][ny][1] = dist[cx][cy][0] + 1
                    queue.offer(Triple(nx, ny, count + 1))
                }

                // 벽 안뚫는 경우
                if (road[nx][ny] == 0 && dist[nx][ny][0] == INF) {
                    dist[nx][ny][0] = dist[cx][cy][0] + 1
                    queue.offer(Triple(nx, ny, count))
                }

            } else {
                // 더이상 벽 못뚫음
                if (road[nx][ny] == 0 && dist[nx][ny][1] == INF) {
                    dist[nx][ny][1] = dist[cx][cy][1] + 1
                    queue.offer(Triple(nx, ny, count))
                }
            }
        }
    }

    val answer = min(dist[rows - 1][cols - 1][0], dist[rows - 1][cols - 1][1])
    print(if (answer == INF) -1 else answer)
}
