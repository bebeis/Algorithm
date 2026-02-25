import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val pq = PriorityQueue<Int>(compareBy({ Math.abs(it) }, { it }))
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val x = readLine().toInt()
        if (x == 0) {
            if (pq.isEmpty()) sb.append("0\n")
            else {
                val top = pq.poll()
                sb.append("$top\n")
            }
        } else {
            pq.offer(x)
        }
    }
    print(sb)
}