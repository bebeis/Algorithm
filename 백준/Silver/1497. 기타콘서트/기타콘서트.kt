const val MAX = 12

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) {
        val (_, status) = readLine().split(" ")
        BooleanArray(m) { idx -> status[idx] == 'Y' }
    }

    val possible = BooleanArray(m)
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j]) possible[j] = true
        }
    }
    val maxSongCount = possible.count { it }

    if (maxSongCount == 0) {
        print(-1)
        return@with
    }

    var songs = BooleanArray(m)
    var min = MAX

    fun bt(arrIdx: Int, cnt: Int) {
        val songCount = songs.count { it }
        if (songCount == maxSongCount) {
            min = minOf(cnt, min)
            return
        }

        for (i in arrIdx until n) {
            val temp = songs.copyOf()
            for ((idx, element) in arr[i].withIndex()) {
                if (element) songs[idx] = true
            }
            bt(i + 1, cnt + 1)
            songs = temp
        }
    }

    bt(0, 0)
    print(min)
}
