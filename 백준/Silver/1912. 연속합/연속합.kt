import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n + 1)
    for (i in 1..n) {
        arr[i] = st.nextToken().toInt()
    }

    val d = IntArray(n + 1)
    for (i in 1..n) {
        d[i] = if (d[i - 1] < 0 || d[i - 1] + arr[i] < 0) arr[i] else d[i - 1] + arr[i]
    }

    print(d.drop(1).max())
}