import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val pq = PriorityQueue<Int>()
    val n = readLine().toInt()
    repeat(n) {
        val st = StringTokenizer(readLine())
        repeat(n) {
            val x = st.nextToken().toInt()
            if (pq.size < n) {
                pq.offer(x)
            } else if (pq.peek() < x) {
                pq.poll()
                pq.offer(x)
            }
        }
    }
    print(pq.poll())
}