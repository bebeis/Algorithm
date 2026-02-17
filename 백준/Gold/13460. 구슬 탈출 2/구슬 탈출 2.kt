
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val origin = Array(n) { readLine().toCharArray() }
    var min = Integer.MAX_VALUE

    fun rotate(board: Array<CharArray>): Array<CharArray>
        = Array(board[0].size) { i -> CharArray(board.size) { j -> board[board.size - 1 - j][i] } }
    
    fun moveToWall(board: Array<CharArray>, moveCnt: Int): Boolean {
        val n = board.size
        val m = board[0].size
        var redHollIn = false
        var blueHollIn = false

        for (cx in 1 until n) {
            for (cy in 1 until m) {
                if (board[cx][cy] != 'R' && board[cx][cy] != 'B') continue

                var ny = cy - 1
                while (ny > 0 && ny < m - 1 && board[cx][ny] == '.') ny--

                // 구멍에 빠지는 경우
                if (board[cx][ny] == 'O') {
                    if (board[cx][cy] == 'R') {
                        redHollIn = true
                        board[cx][cy] = '.'
                        continue
                    }
                    
                    else if (board[cx][cy] == 'B') {
                        blueHollIn = true
                        board[cx][cy] = '.'
                        continue
                    }
                }

                ny++
                // 벽에 부딪히는 경우 또는 구슬에 부딪히는 경우
                var cur = board[cx][cy]
                board[cx][cy] = '.'
                board[cx][ny] = cur
            }
        }

        if (blueHollIn) return false
        if (redHollIn) {
            min = minOf(min, moveCnt)
            return false
        }
        return true
    }

    fun solve(board: Array<CharArray>, moveCnt: Int) {
        if (moveCnt > 10) return
    
        for (dir in 1..4) {
            var rotated = Array(board.size) { i -> board[i].copyOf() }
            repeat(dir) { rotated = rotate(rotated) }
            val tempResult = moveToWall(rotated, moveCnt)
            if (!tempResult) continue
            solve(rotated, moveCnt + 1)
        }
    }

    solve(origin, 1)
    print(if (min == Integer.MAX_VALUE) -1 else min)
}