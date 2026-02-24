import java.util.*

/**
 * 내림차순 유지하다가 깨지는 순간 pop
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }
    val stack = ArrayDeque<Pair<Int, Int>>()
    val result = IntArray(n)

    for ((i, x) in arr.withIndex()) {
        while (stack.isNotEmpty() && stack.peek().second < x) {
            val (idx, num) = stack.pop()
            result[idx] = x
        }
        stack.push(i to x)
    }

    while (stack.isNotEmpty()) {
        val (idx, num) = stack.pop()
        result[idx] = -1
    }

    print(result.joinToString(" "))
}