import java.io.*
import java.util.*
import kotlin.math.*

fun recursive(base: Long, exp: Long, divisor: Long): Long {
    if (exp == 1L) {
        return base % divisor
    }

    val tmp = recursive(base, exp / 2, divisor)
    if (exp % 2 != 0L) {
        return (((tmp * tmp) % divisor) * base) % divisor
    }

    return (tmp * tmp) % divisor
}

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine().split(" ").map { it.toLong() }
    print(recursive(a, b, c))
}