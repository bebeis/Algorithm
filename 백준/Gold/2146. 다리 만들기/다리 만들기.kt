/**
 * 가장 짧은 다리를 놓아 두 대륙을 연결해야 함
 * 해결 방법: 모든 점에서 bfs를 돌려서, 다른 섬에 도달하게 되는 가장 빠른 시점 구하기
 *   1. 영역별로 라벨링하기 O(n^2)
 *   2. 육지의 모든 점에서 bfs 돌리기
 *      - 이미 방문한 곳 스킵
 *      - 라벨 번호로 영역 확장
 *      - 확장되고 있는 서로 다른 영역이 만난다면, 거리 더해서 정답 구하기
 */

/**
 * 처음에 틀린 이유: early return하고 종료시켜버림. 
 * queue를 사용하긴 하지만, 첫 번째 충돌이 최솟값이 아닐 수 있다.
 * 일반적인 multi-source BFS처럼 "동시에 출발"하는 게 아니라, 섬 1이 먼저 확장할 기회를 더 많이 가진다.
 * 
 */

import java.util.*

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val board = Array(n) { StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } } }

    val fq = ArrayDeque<Pair<Int, Int>>()
    val dist = Array(n) { IntArray(n) }

    var labelId = 1
    val labelVisited = Array(n) { BooleanArray(n) }
    
    for (i in 0 until n) for (j in 0 until n) {
        if (board[i][j] == 0 || labelVisited[i][j]) continue

        val queue = ArrayDeque<Pair<Int, Int>>()
        labelVisited[i][j] = true
        board[i][j] = labelId
        queue.offer(i to j)

        while (queue.isNotEmpty()) {
            var (cx, cy) = queue.poll()
            fq.offer(cx to cy)

            for (d in 0 until 4) {
                val nx = cx + dx[d]
                val ny = cy + dy[d]

                if (nx !in 0..n-1 || ny !in 0..n-1) continue
                if (board[nx][ny] == 0 || labelVisited[nx][ny]) continue
                labelVisited[nx][ny] = true
                board[nx][ny] = labelId
                queue.offer(nx to ny)
            }
        }

        labelId++
    }

    var ans = Int.MAX_VALUE

    // 2. flood 작업
    while (fq.isNotEmpty()) {
        val (cx, cy) = fq.poll()

        for (d in 0 until 4) {
            val nx = cx + dx[d]
            val ny = cy + dy[d]

            if (nx !in 0..n-1 || ny !in 0..n-1) continue
            if (board[nx][ny] == board[cx][cy]) continue
            if (board[nx][ny] == 0) {
                board[nx][ny] = board[cx][cy]
                dist[nx][ny] = dist[cx][cy] + 1
                fq.offer(nx to ny)
            } else {
                ans = minOf(ans, dist[nx][ny] + dist[cx][cy])
            }
        }
    }
    print(ans)
}