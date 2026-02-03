import java.util.*

// i 번째 비트 키기
infix fun Int.on(i: Int) = this or (1 shl i - 1)

// i 번째 비트 끄기
infix fun Int.off(i: Int) = this and (1 shl i - 1).inv()

// i 번째 비트 체크하기
infix fun Int.check(i: Int) = if (this and (1 shl i - 1) >= 1) 1 else 0

// i 번째 비트 토글하기
infix fun Int.toggle(i: Int) = this xor (1 shl i - 1)

fun main() = with(System.`in`.bufferedReader()) {
    var status = 0
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val parts = readLine().split(" ")
        val command = parts[0]
        val num = parts.last().toIntOrNull() ?: 0
        when (command) {
            "add" -> status = status on num
            "remove" -> status = status off num
            "check" -> sb.append(status check num).append('\n')
            "toggle" -> status = status toggle num
            "all" -> status = (1 shl 20) - 1
            "empty" -> status = 0
        }
    }
    print(sb)
}