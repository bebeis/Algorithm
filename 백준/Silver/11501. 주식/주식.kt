import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val arr = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }

        var earn = 0L
        var max = 0
        for (i in n - 1 downTo 0) {
            if (arr[i] > max) max = arr[i]
            else earn += max - arr[i]
        }
        println(earn)
    }
}