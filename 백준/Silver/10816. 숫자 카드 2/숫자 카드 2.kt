import java.util.*

fun IntArray.lowerbound(target: Int): Int {
    var lo = -1
    var high = this.size

    while (lo + 1 < high) {
        val mid = (lo + high) / 2
        if (this[mid] >= target) high = mid
        else lo = mid
    }
    return high
}

fun IntArray.upperbound(target: Int): Int {
    var lo = -1
    var high = this.size

    while (lo + 1 < high) {
        val mid = (lo + high) / 2
        if (this[mid] > target) high = mid
        else lo = mid
    }
    return high
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = StringTokenizer(readLine()).run { IntArray(n) { nextToken().toInt() }}.sortedArray()
    val q = readLine().toInt()
    print(StringTokenizer(readLine()).run { IntArray(q) { nextToken().toInt().let {arr.upperbound(it) - arr.lowerbound(it)} } }
        .joinToString(" "))
}