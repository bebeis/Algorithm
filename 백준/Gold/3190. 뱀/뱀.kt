import java.util.*

fun Int.rightDir(): Int {
    return (this + 3) % 4
}

fun Int.leftDir(): Int {
    return (this + 1) % 4
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val board = Array(n + 1) { IntArray(n + 1) }
    val dirBoard = Array(n + 1) { IntArray(n + 1) }
    val rotateInfo = CharArray(10_001) { 'N' }

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val i = st.nextToken().toInt()
        val j = st.nextToken().toInt()
        board[i][j] = 2 // 1: 뱀, 2: 사과
    }

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val time = st.nextToken().toInt()
        val c = st.nextToken()[0]
        rotateInfo[time] = c
    }

    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    var dir = 1

    var time = 0
    var cx = 1
    var cy = 1
    var tx = 1
    var ty = 1

    board[cx][cy] = 1

    while (true) {
        when (rotateInfo[time]) {
            'L' -> dir = dir.leftDir()
            'D' -> dir = dir.rightDir()
        }
        dirBoard[cx][cy] = dir

        val nx = cx + dx[dir]
        val ny = cy + dy[dir]

        if (nx <= 0 || ny <= 0 || nx > n || ny > n) break
        if (board[nx][ny] == 1) break
        if (board[nx][ny] == 2) {
            board[nx][ny] = 1
            cx = nx
            cy = ny
        } else {
            board[nx][ny] = 1
            cx = nx
            cy = ny

            board[tx][ty] = 0
            val taildir = dirBoard[tx][ty]
            tx = tx + dx[taildir]
            ty = ty + dy[taildir]
        }

        time++
    }
    print(time + 1)
}