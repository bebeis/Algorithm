import java.util.*

// d[x]: x가 선택되었을 때, 가장 긴 수열의 길이
// d[x]: d[k] + 1 (k는, arr[x] 보다 arr[k]가 작지만 d[k]가 가장 큰 것)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }
    val d = IntArray(n)

    for (i in 0 until n) {
        d[i] = 1
        for (j in i - 1 downTo 0) {
            if (arr[j] < arr[i]) d[i] = maxOf(d[i], d[j] + 1)
        }
    }

    print(d.max())
}