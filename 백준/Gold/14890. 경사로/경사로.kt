/**
 * 규칙
 * - 1. 길을 지나갈 수 있으려면 길에 속한 모든 칸의 높이가 모두 같아야 한다.
 * - 2. 높이가 다르다면 경사로를 놓아 연결해준다. (높이는 1, 길이는 L, 개수 무제한)
 *   - 경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
 *   - 낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
 *   - 경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속되어 있어야 한다.
 *   - 경사로를 놓은 곳에 또 경사로를 놓을 수 없다.
 *   - 경사로를 놓다가 범위를 벗어나면 안 된다
*/

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    var board = Array(n) { StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } } }

    var cnt = 0
    fun logic() {
        for (row in 0 until n) {
            var used = BooleanArray(n)

            // 내리막 검사
            var cur = 0
            while (cur < n - 1) {
                val diff = board[row][cur] - board[row][cur + 1]
                if (diff == 0 || diff < 0) {
                    cur++
                    continue
                }
                if (diff >= 2) break

                // 차이가 1 나는 상황
                var descnt = 1
                for (nxt in cur + 2 until cur + 1 + l) {
                    if (nxt > n - 1) break
                    if (board[row][nxt] != board[row][nxt - 1]) {
                        break
                    } else {
                        descnt++
                    }
                }

                if (descnt == l) {
                    for (nxt in cur + 1 until cur + l + 1) {
                        used[nxt] = true
                    }
                    cur = cur + l
                } else {
                    break
                }
            }

            if (cur != n - 1) continue
            // 오르막 검사 -> 거꾸로 순회해서 내리막으로

            while (cur > 0) {
                val diff = board[row][cur] - board[row][cur - 1]
                if (diff == 0 || diff < 0) {
                    cur--
                    continue
                }
                if (diff >= 2) break

                // 차이가 1 나는 상황
                var descnt = 1
                if (used[cur - 1]) break
                for (nxt in cur - 2 downTo cur - l) {
                    if (nxt < 0) break
                    if (board[row][nxt] != board[row][nxt + 1] || used[nxt]) {
                        break
                    } else {
                        descnt++
                    }
                }

                if (descnt == l) {
                    for (nxt in cur - 1 downTo cur - l) {
                        used[nxt] = true
                    }
                    cur = cur - l
                } else {
                    break
                }
            }

            if (cur == 0) {
                cnt++
            }
        }
    }
    logic()

    // board 피벗시키기
    val newBoard = Array(n) { i -> IntArray(n) { j -> board[n - 1 - j][i] } }
    board = newBoard
    logic()

    print(cnt)
}