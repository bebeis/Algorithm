import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var sum = 0L
    val map = HashMap<String, PriorityQueue<Int>>()

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val command = st.nextToken().toInt()
        val name = st.nextToken()

        if (command == 1) {
            val pq = map.getOrDefault(name, PriorityQueue<Int>(Comparator { x, y -> y.compareTo(x) }))
            repeat(st.nextToken().toInt()) {
                pq.offer(st.nextToken().toInt())
            }
            map[name] = pq
        } else {
            var buyCount = st.nextToken().toInt()
            val pq = map.getOrDefault(name, PriorityQueue<Int>(Comparator { x, y -> y.compareTo(x) }))

            while (buyCount > 0 && pq.isNotEmpty()) {
                sum += pq.poll().toLong()
                buyCount--
            }
        }
    }
    print(sum)
}