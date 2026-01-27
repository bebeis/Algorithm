import kotlin.math.*
import java.io.*
import java.util.*

/**
 * 문제: bfs를 돌리면서 영역의 개수가 2개 이상이 되는 시점 구하기
 * 조건
 * - 각 노드의 값이 1 사이클마다 감소할 수 있음
 * - 최대 영역의 크기: 300
 * 
 * 한 사이클에서의 동작
 * - bfs를 돌려서 영역의 수 구하기: 90,000
 * - 영역이 2개 이상인지 / 0개 인지 검사 -> 탈출
 * - 4개의 주변 블록을 살펴서 다음 사이클의 상태 저장(90,000)
 *  - 다른 배열에 mirroring
 * - 사이클++
 */

val dx = listOf(1, 0, -1, 0)
val dy = listOf(0, 1, 0, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var board1 = Array(n) { 
        StringTokenizer(readLine()).run() {
            IntArray(m) { nextToken().toInt() }
        }
    }

    var board2 = Array(n) { IntArray(m) }
    var useFirst = true
    var cycle = 0
    while (true) {
        var visited = Array(n) { BooleanArray(m) }
        val board = if (useFirst) board1 else board2
        val mirror = if (useFirst) {
            board2 = Array(n) { IntArray(m) }
            board2
        } else {
            board1 = Array(n) { IntArray(m) }
            board1
        }
        
        var cnt = 0
        for (i in 0..n - 1) {
            for (j in 0..m - 1) {
                if (board[i][j] == 0 || visited[i][j]) continue
                val queue: Queue<Pair<Int, Int>> = ArrayDeque()
                queue.offer(Pair(i, j))
                visited[i][j] = true

                while (queue.isNotEmpty()) {
                    val (cx, cy) = queue.poll()
                    var adjCount = 0

                    for (k in 0..3) {
                        val nx = cx + dx[k]
                        val ny = cy + dy[k]

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                        if (visited[nx][ny]) continue
                        if (board[nx][ny] == 0) {
                            adjCount++
                            continue
                        }
                        visited[nx][ny] = true
                        queue.offer(Pair(nx, ny))
                    }

                    mirror[cx][cy] = 
                        if (board[cx][cy] - adjCount >= 0) board[cx][cy] - adjCount else 0
                }
                cnt++
            }
        }

        if (cnt == 0) {
            cycle = 0
            break
        }

        if (cnt >= 2) {
            break
        }

        cycle++
        useFirst = !useFirst
    }
    print(cycle)
}