import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    print(List(readLine().toInt()) {
        val cnt = mutableMapOf<String, Int>()
        repeat(readLine().toInt()) {
            val cat = StringTokenizer(readLine()).also { it.nextToken() }.nextToken()
            cnt[cat] = cnt.getOrDefault(cat, 0) + 1
        }
        cnt.values.fold(1) { acc, v -> acc * (v + 1) } - 1
    }.joinToString("\n"))
}