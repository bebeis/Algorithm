import java.util.ArrayDeque

private data class State(val rx: Int, val ry: Int, val bx: Int, val by: Int, val d: Int)
private data class RollResult(val x: Int, val y: Int, val moved: Int, val inHole: Boolean)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().toCharArray() }

    var rx = 0; var ry = 0; var bx = 0; var by = 0
    for (i in 0 until n) for (j in 0 until m) {
        when (board[i][j]) {
            'R' -> { rx = i; ry = j; board[i][j] = '.' }
            'B' -> { bx = i; by = j; board[i][j] = '.' }
        }
    }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun roll(sx: Int, sy: Int, dir: Int): RollResult {
        var x = sx
        var y = sy
        var moved = 0
        while (true) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]
            if (board[nx][ny] == '#') break
            x = nx; y = ny; moved++
            if (board[x][y] == 'O') return RollResult(x, y, moved, true)
        }
        return RollResult(x, y, moved, false)
    }

    val nm = n * m
    fun idx(rx: Int, ry: Int, bx: Int, by: Int): Int {
        val r = rx * m + ry
        val b = bx * m + by
        return r * nm + b
    }

    val visited = BooleanArray(nm * nm)
    val q = ArrayDeque<State>()
    visited[idx(rx, ry, bx, by)] = true
    q.add(State(rx, ry, bx, by, 0))

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        if (cur.d == 10) continue

        for (dir in 0..3) {
            val r = roll(cur.rx, cur.ry, dir)
            val b = roll(cur.bx, cur.by, dir)

            // 파란 구슬이 빠지면 실패
            if (b.inHole) continue

            // 빨간 구슬만 빠지면 성공
            if (r.inHole) {
                println(cur.d + 1)
                return@with
            }

            var nrx = r.x; var nry = r.y
            var nbx = b.x; var nby = b.y

            // 겹치면 이동 많이 한 쪽을 한 칸 뒤로
            if (nrx == nbx && nry == nby) {
                if (r.moved > b.moved) {
                    nrx -= dx[dir]
                    nry -= dy[dir]
                } else {
                    nbx -= dx[dir]
                    nby -= dy[dir]
                }
            }

            val key = idx(nrx, nry, nbx, nby)
            if (!visited[key]) {
                visited[key] = true
                q.add(State(nrx, nry, nbx, nby, cur.d + 1))
            }
        }
    }

    println(-1)
}
