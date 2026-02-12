fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n) { readLine().toInt() }.sortedArray()

    var min = Integer.MAX_VALUE
    var st = 0
    var ed = 0
    while (st < n && ed < n) {
        val diff = arr[st] - arr[ed]
        if (diff >= m) min = minOf(min, diff)

        if (st == ed) {
            st++
        } else if (diff >= m) {
            ed++
        } else {
            st++
        }
    }
    print(min)
}