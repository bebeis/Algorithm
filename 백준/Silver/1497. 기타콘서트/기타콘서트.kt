fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    infix fun Long.on(i: Int) = this or (1L shl (i - 1))
    infix fun Long.check(i: Int) = if (this and (1L shl (i - 1)) >= 1L) 1 else 0
    infix fun Long.union(other: Long): Long {
        var tmp = this
        for (i in 1..m) {
            if (other.check(i) == 1) {
                tmp = tmp.on(i)
            }
        }
        return tmp
    }

    val arr = LongArray(n) {
        val (_, status) = readLine().split(" ")
        var temp = 0L
        for ((idx, element) in status.toCharArray().withIndex()) {
            if (element == 'Y') temp = temp.on(idx + 1)
        }
        temp
    }

    val unioned = arr.fold(0L, Long::union)
    val maxSongCount = unioned.countOneBits()
    if (maxSongCount == 0) {
        print(-1)
        return@with
    }

    var songs = 0L
    var min = 12

    fun bt(arrIdx: Int, cnt: Int) { 
        if (songs.countOneBits() == maxSongCount) {
            min = minOf(cnt, min)
            return
        }

        for (i in arrIdx until n) {
            val temp = songs
            songs = songs.union(arr[i])
            bt(i + 1, cnt + 1)
            songs = temp
        }
    }

    bt(0, 0)
    print(min)
}