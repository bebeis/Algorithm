import java.io.*
import java.util.*
import kotlin.math.*

// 문제: pop 결과로 부터 오름차순 push/pop 과정을 유추
/**
 * arr[i]를 pop하기 위해선, 
 * - arr[i]가 stack의 top에 존재해야 한다.
 * - 즉, stack의 top에 arr[i]가 없으면 해당 arr[i]까지 push 해야한다.
 *     - 근데, arr[i]가 top에 있는 것 보다 작으면? 불가능하다.
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val sb = StringBuilder()
    val stack: Deque<Int> = ArrayDeque()
    var cur = 1
    repeat(n) {
        val x = readLine().toInt()

        while (stack.isEmpty() || stack.peek() < x) {
            stack.push(cur++)
            sb.append("+\n")
        }

        if (stack.peek() != x) {
            print("NO")
            System.exit(0)
        }

        stack.pop()
        sb.append("-\n")
    }

    print(sb)
}