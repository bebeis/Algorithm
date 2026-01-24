import java.io.*
import java.util.*
import kotlin.math.*

/**
 * 슬라이딩 윈도우의 크기가 주어졌을 때,
 * 문제: 슬라이딩 윈도우를 움직이면서 각 상태에서의 최솟값 구하기
 * - 브루트포스 -> 시간 초과
 * - 상태를 유지하면서 매 상태에 상수 or 로그 시간에 처리해야 함
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(' ').map { it.toInt() }
    val arr = IntArray(n)
    with(StringTokenizer(readLine())) {
        for (i in 0 until n) {
            arr[i] = nextToken().toInt()
        }
    }
    
    val dq: Deque<Int> = ArrayDeque() 
    val sb = StringBuilder()

    for (i in 0 until n) {
        // head 로직
        if (dq.isEmpty()) {
            dq.offerFirst(arr[i])
        } else {
            while (dq.isNotEmpty() && arr[i] < dq.peekLast()) {
                dq.removeLast()
            }
            dq.offerLast(arr[i])
        }

        // 최솟값 누적
        sb.append(dq.peekFirst()).append(' ')

        // tail 로직
        val tailIdx = i - l + 1
        if (tailIdx < 0) continue
        if (arr[tailIdx] == dq.peekFirst()) {
            dq.removeFirst()
        }
    }
    print(sb)
}