import java.util.*

fun isPrime(n: Int): Boolean {
    if (n == 1) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    var cnt = 0
    repeat(n) {
        val x = st.nextToken().toInt()
        if (isPrime(x)) cnt++
    }
    print(cnt)
}