import java.io.*
import java.util.*
import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n)
    val positions = IntArray(n) { 0 }
    with (StringTokenizer(readLine())) {
        for (i in 0..n - 1) {
            arr[i] = nextToken().toInt()
        }
    }

    val stack: Deque<Pair<Int, Int>> = ArrayDeque() // 값, 좌표
    for ((idx, value) in arr.withIndex().reversed()) {
        while (stack.isNotEmpty() && stack.peek().first <= value) {
            positions[stack.pop().second] = idx + 1
        }

        stack.push(Pair(value, idx))
    }

    print(positions.joinToString(" "))
}