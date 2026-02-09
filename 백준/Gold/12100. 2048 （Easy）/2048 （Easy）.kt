/**
 * 규칙
 * - 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다
 * - 한 번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없다.
 * - 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다.
 * 구하고자 하는 것
 * - 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값
 */
import java.util.*

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var board = Array(n) { StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } } }

    fun moveHorizon(dir: Int) {
        val collision = Array(n) { BooleanArray(n) }
        val (sy, ey) = if (dir == 1) (n - 1 to 0) else (0 to n - 1)
        for (cx in 0 until n) {
            val blockIndexes = mutableListOf<Int>()
            for (cy in IntProgression.fromClosedRange(sy, ey, -dy[dir])) {
                if (board[cx][cy] != 0) blockIndexes.add(cy)
            }

            for (cy in blockIndexes) {
                var ty = cy + dy[dir] // ty는 블록이 합쳐지거나 위치할 곳의 다음 위치
                while ((ty in 0 until n) && (board[cx][ty] == 0)) ty += dy[dir]

                // 벽으로 부딪히는 경우
                if (ty !in 0 until n) {
                    ty = ty - dy[dir]
                    if (ty == cy) continue
                    board[cx][ty] = board[cx][cy]
                    board[cx][cy] = 0
                    continue
                }

                // 기존 블록과 부딪히는 경우
                // 1. 값이 같고, 충돌한 적이 없는 경우
                if (board[cx][ty] == board[cx][cy] && !collision[cx][ty]) {
                    board[cx][ty] *= 2
                    collision[cx][ty] = true
                    board[cx][cy] = 0
                    continue
                }

                // 그 외의 경우
                ty = ty - dy[dir]
                if (ty != cy) {
                    board[cx][ty] = board[cx][cy]
                    board[cx][cy] = 0
                }
            }
        }
    }

    fun moveVertical(dir: Int) {
        val collision = Array(n) { BooleanArray(n) }
        val (sx, ex) = if (dir == 0) (n - 1 to 0) else (0 to n - 1)
        for (cy in 0 until n) {
            val blockIndexes = mutableListOf<Int>()
            for (cx in IntProgression.fromClosedRange(sx, ex, -dx[dir])) {
                if (board[cx][cy] != 0) blockIndexes.add(cx)
            }

            for (cx in blockIndexes) {
                var tx = cx + dx[dir]
                while ((tx in 0 until n) && (board[tx][cy] == 0)) tx += dx[dir]

                // 벽으로 부딪히는 경우
                if (tx !in 0 until n) {
                    tx = tx - dx[dir]
                    if (tx == cx) continue
                    board[tx][cy] = board[cx][cy]
                    board[cx][cy] = 0
                    continue
                }

                // 기존 블록과 부딪히는 경우
                // 1. 값이 같고, 충돌한 적이 없는 경우
                if (board[tx][cy] == board[cx][cy] && !collision[tx][cy]) {
                    board[tx][cy] *= 2
                    collision[tx][cy] = true
                    board[cx][cy] = 0
                    continue
                }

                tx = tx - dx[dir]
                if (tx != cx) {
                    board[tx][cy] = board[cx][cy]
                    board[cx][cy] = 0
                }
            }
        }
    }

    fun moveDir(dir: Int) {
        if (dir == 1 || dir == 3) moveHorizon(dir)
        else moveVertical(dir)
    }

    var max = 0
    fun move(moveCnt: Int) {
        if (moveCnt == 5) {
            val localMax = board.maxOf { line -> line.max() }
            max = maxOf(max, localMax)
            return
        }
        
        for (i in 0 until 4) {
            val originBoard = Array(n) { idx -> board[idx].clone() }
            moveDir(i)
            move(moveCnt + 1)
            board = originBoard
        }
    }

    move(0)
    print(max)
}