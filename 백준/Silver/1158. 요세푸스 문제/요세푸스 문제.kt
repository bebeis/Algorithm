import java.util.*

/**
 * 풀이: 두 가지
 * 1. 큐를 이용하여 원형 순회 구현하기
 * 2. 연결 리스트 흉내내기
 */

val left = IntArray(5001) { i -> i - 1 }
val right = IntArray(5001) { i -> i + 1 }

fun remove(idx: Int) {
    val originRight = right[idx]
    val originLeft = left[idx]
    right[originLeft] = originRight
    left[originRight] = originLeft
}

fun move(start: Int, cnt: Int): Int {
    var nxt = start
    repeat(cnt) {
        nxt = right[nxt]
    }

    return nxt
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    left[1] = n
    right[n] = 1

    val list = mutableListOf<Int>()
    var target = 0
    repeat(n) {
        target = move(target, k)
        list.add(target)
        remove(target)
    }

    print(list.joinToString(", ", "<", ">"))
}