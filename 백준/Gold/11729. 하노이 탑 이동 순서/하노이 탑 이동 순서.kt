import kotlin.math.*
import java.util.*

/**
 * k번째 원판을 1 -> 3으로옮기려면
 * - 1 ~ k-1번째 원판을 1 -> 2로 옮기고
 * - k번째 원판을 1 -> 3으로 옮기고
 * - 1 ~ k-1번째 원판을 2 -> 3으로 옮김
 */

val sb = StringBuilder()
var cnt = 0
fun hanoi(base: Int, from: Int, to: Int) {
    if (base == 1) {
        sb.append(from).append(' ').append(to).append('\n')
        cnt++
        return
    }

    val mid = 6 - from - to

    hanoi(base - 1, from, mid)
    sb.append(from).append(' ').append(to).append('\n')
    cnt++
    hanoi(base - 1, mid, to)
}

fun main() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    hanoi(k, 1, 3)
    println(cnt)
    print(sb)
}