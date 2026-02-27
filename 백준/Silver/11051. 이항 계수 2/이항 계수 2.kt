const val MOD = 10_007L
fun modPow(a: Long, e: Long): Long {
    var base = a % MOD
    var exp = e
    var res = 1L
    while (exp > 0) {
        if ((exp and 1L) == 1L) res = (res * base) % MOD
        base = (base * base) % MOD
        exp = exp shr 1
    }
    return res
}

fun comb(n: Int, k: Int): Long {
    if (n == 0 || k == 0) return 1
    if (k > n) return 0

    var up = 1L
    var down = 1L
    for (i in 1..k) {
        up = up * (n - k + i) % MOD
        down = down * i % MOD
    }

    return (up * modPow(down, MOD - 2) % MOD)
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    print(comb(n, k))
}