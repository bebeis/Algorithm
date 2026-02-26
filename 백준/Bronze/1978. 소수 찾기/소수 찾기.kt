import java.util.*

fun isPrime(n: Int): Int {
    if (n == 1) return 0
    for (i in 2..n) {
        if (i * i > n) break
        if (n % i == 0) return 0
    }
    return 1
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    var cnt = 0
    repeat(n) {
        val x = st.nextToken().toInt()
        cnt += isPrime(x)
    }
    print(cnt)
}   