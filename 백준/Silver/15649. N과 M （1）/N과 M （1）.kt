import kotlin.math.*
import java.util.*

/**
 * path당 상태를 유지해야하는 것
 * - 현재 몇 개를 골랐는지: 탈출 조건
 * - 지금까지 어떤 숫자를 사용했는지 (중복 금지)
 */




fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val used = BooleanArray(n + 1)
    val arr = IntArray(m)
    val sb = StringBuilder()
    
    fun bt(cur: Int) {
        if (cur == m) {
            arr.forEach { sb.append(it).append(' ') }
            sb.append('\n')
            return
        }

        for (i in 1..n) {
            if (used[i]) continue

            used[i] = true
            arr[cur] = i
            bt(cur + 1)
            used[i] = false
        }
    }

    bt(0)
    print(sb)
}