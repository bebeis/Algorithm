/**
 * 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로
 */

/**
 * 1. 5개 중에 1개 선택 : 5개
 * 2. 가능한 board 조합: 8개
 * 5. 테트로미노 하나를 배치할 곳을 선택 : nm(250000)
 * 6. 최대합 구하기: 4
 */
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var board = Array(n) { StringTokenizer(readLine()).let { st -> IntArray(m) { st.nextToken().toInt() } } }

    fun rotate(origin: Array<IntArray>): Array<IntArray> 
        = Array(origin[0].size) { i -> IntArray(origin.size) { j -> origin[origin.size - 1 - j][i] } }
    
    fun reverse(origin: Array<IntArray>): Array<IntArray> 
        = Array(origin.size) { i -> IntArray(origin[0].size) { j -> origin[i][origin[0].size - 1 - j] } }

    var reversedBoard = reverse(board)

    val boards = mutableListOf<Array<IntArray>>()
    repeat(4) {
        board = rotate(board)
        reversedBoard = rotate(reversedBoard)
        boards.add(board)
        boards.add(reversedBoard)
    }

    val diffs = listOf(
        listOf(0 to 1, 0 to 1, 0 to 1),
        listOf(1 to 0, 1 to 0, 0 to 1),
        listOf(1 to 0, 0 to 1, 1 to 0),
        listOf(0 to 1, 0 to 1, 1 to -1),
        listOf(0 to 1, 1 to 0, 0 to -1)
    )

    var max = 0

    fun choose(blockId: Int) {
        val d = diffs[blockId]
        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) label@{
                var cx = i
                var cy = j
                var localSum = board[cx][cy]

                var flag = false
                for (k in 0 until 3) {
                    cx = cx + d[k].first
                    cy = cy + d[k].second

                    if (cx < 0 || cx >= board.size || cy < 0 || cy >= board[0].size) {
                        flag = true
                        break;
                    }
                    localSum += board[cx][cy]
                }
                if (flag) continue
                max = maxOf(max, localSum)
            }
        }
    }

    fun solve() {
        for (i in 0 until 8) {
            board = boards[i]
            for (j in 0 until 5) {
                choose(j)
            }
        }
    }

    solve()
    print(max)
}