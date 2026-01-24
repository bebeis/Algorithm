import java.io.*;
import java.util.*;
import kotlin.math.*;

/**
 * R: 뒤집기
 * D: 첫 번째 수를 버림 (배열이 이어있는 경우 에러)
 * 커맨드는 조합해서 사용 가능
 * 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하기
 */

fun main() = with(System.`in`.bufferedReader()) {
    var t = readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val commands = readLine()
        val n = readLine().toInt()
        val deque = toDeque(readLine())
        var reverseFlag = false
        var errorFlag = false

        for (command in commands) {
            if (command == 'R') {
                reverseFlag = !reverseFlag
            } else { // D
                if (deque.isEmpty()) {
                    errorFlag = true
                    break;
                }
                if (reverseFlag) {
                    deque.pollLast()
                } else {
                    deque.pollFirst()
                }
            }
        }

        if (errorFlag) {
            sb.append("error\n")
        } else {
            sb.append(toString(deque, reverseFlag)).append('\n')
        }
    }
    print(sb)
}

fun toDeque(line: String): Deque<Int> {
    return ArrayDeque(
        line.substring(1, line.length - 1)
        .split(",")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }
    )
}

fun toString(deque: Deque<Int>, reverseFlag: Boolean): String {
    if (reverseFlag) {
        return deque.reversed().joinToString(prefix = "[", postfix = "]", separator = ",")
    }
    return deque.joinToString(prefix = "[", postfix = "]", separator = ",")
}