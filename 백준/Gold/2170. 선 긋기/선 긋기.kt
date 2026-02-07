import java.util.*
fun main() = with(System.`in`.bufferedReader()) {
    val arr = Array(readLine().toInt()) {
        with(StringTokenizer(readLine())) {
            nextToken().toInt() to nextToken().toInt()
        }
    }.sortedWith(compareBy<Pair<Int, Int>>{ it.first }.thenBy{ it.second })

    var totalLength = 0
    var chunkStart = -1_000_000_000
    var chunkEnd = -1_000_000_000
    for ((start, end) in arr) {
        if (start <= chunkEnd) {
            if (end <= chunkEnd) continue
            else chunkEnd = end
        } else {
            totalLength += (chunkEnd - chunkStart)
            chunkStart = start
            chunkEnd = end
        }
    }
    totalLength += (chunkEnd - chunkStart)
    print(totalLength)
}