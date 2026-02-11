/**
 * 5×5 크기의 판이 5개 
 * 하얀 칸은 참가자가 들어갈 수 있는 칸, 검은 칸은 참가자가 들어갈 수 없는 칸
 * 주어진 판들을 시계 방향, 혹은 반시계 방향으로 자유롭게 회전 가능
 * 회전을 완료하고 5개의 판을 원하는 순서대로 배치 가능
 * 정육면체에서 출발점 임의로 선택(꼭짓점 중에서), 도착지는 정반대
 * 
 * 이동 규칙
 * - 면으로 인접한 칸이 참가자가 들어갈 수 있는 칸인 경우
 * 
 * 본인이 설계한 미로 중 가장 적은 이동 횟수로 탈출한 사람이 우승
 * 미로의 입구 혹은 출구가 막혀있거나, 입구에서 출구에 도달할 수 있는 방법이 존재하지 않을 경우에는 탈출 불가능
 * 첫째 줄에 주어진 판으로 설계된 미로를 탈출하는 가장 적은 이동 횟수
 */

import java.util.*

const val MAX = 5
const val INF = 1000


fun rotate(board: Array<IntArray>): Array<IntArray> = 
    Array(MAX) { i -> IntArray(MAX) { j -> board[j][MAX - i - 1]}}

fun main() = with(System.`in`.bufferedReader()) {
    val dx = listOf(1, 0, -1, 0, 0, 0)
    val dy = listOf(0, 1, 0, -1, 0, 0)
    val dz = listOf(0, 0, 0, 0, 1, -1)

    val starts = listOf(
        Triple(0, 0, 0),
        Triple(0, MAX - 1, 0),
        Triple(MAX - 1, 0, 0),
        Triple(MAX - 1, MAX - 1, 0)
    )

    val ends = listOf(
        Triple(MAX - 1, MAX - 1, MAX - 1),
        Triple(MAX - 1, 0, MAX - 1),
        Triple(0, MAX - 1, MAX - 1),
        Triple(0, 0, MAX - 1)
    )

    var boards = Array(MAX) { Array(MAX) { StringTokenizer(readLine()).let { st -> IntArray(MAX) { st.nextToken().toInt() } } } }
    val rotations = Array(MAX) { i ->
        Array(4) { r ->
            var b = boards[i]
            repeat(r) { b = rotate(b) }
            b
        }
    }

    var cube = Array(MAX) { Array(MAX) { IntArray(MAX) } }
    val used = BooleanArray(MAX)
    var min = INF

    fun bfs(id: Int): Int {
        val s = starts[id]
        val e = ends[id]
        if (cube[s.third][s.first][s.second] == 0) return INF
        if (cube[e.third][e.first][e.second] == 0) return INF

        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        val visited = Array(MAX) { Array(MAX) { BooleanArray(MAX) } }
        val dists = Array(MAX) { Array(MAX) { IntArray(MAX) { INF } } }
        visited[s.third][s.first][s.second] = true
        dists[s.third][s.first][s.second] = 0
        queue.offer(s)

        while (!queue.isEmpty()) {
            val c = queue.poll()
            if (c == e) return dists[c.third][c.first][c.second]

            for (i in 0 until 6) {
                val nx = c.first + dx[i]
                val ny = c.second + dy[i]
                val nz = c.third + dz[i]

                if (nx < 0 || ny < 0 || nz < 0 || nx >= MAX || ny >= MAX || nz >= MAX) continue
                if (cube[nz][nx][ny] == 0) continue
                if (visited[nz][nx][ny]) continue

                visited[nz][nx][ny] = true
                dists[nz][nx][ny] = dists[c.third][c.first][c.second] + 1
                queue.offer(Triple(nx, ny, nz))
            }
        }

        return INF
    }

    fun batch(z: Int) {
        if (z == MAX) {
            val result = bfs(0)
            min = minOf(min, result)
            return
        }

        for (i in 0 until MAX) {
            if (used[i]) continue
            cube[z] = boards[i]
            used[i] = true
            batch(z + 1)
            used[i] = false
        }
    }

    fun solve(boardIdx: Int) {
        if (boardIdx == MAX) {
            batch(0)
            return
        }

        for (r in 0 until 4) {
            boards[boardIdx] = rotations[boardIdx][r]
            solve(boardIdx + 1)
        }
    }

    solve(0)
    print(if (min == INF) -1 else min)
}