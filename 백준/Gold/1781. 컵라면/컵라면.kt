import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    val arr = Array(readLine().toInt()) { StringTokenizer(readLine()).let { st -> st.nextToken().toInt() to st.nextToken().toInt() } }
        .sortedWith(compareBy<Pair<Int, Int>>{ it.first }.thenBy { it.second } )

    val pq = PriorityQueue<Int>()

    var time = 0
    for ((dead, cnt) in arr) {
        if (time < dead) {
            time++
            pq.offer(cnt)
        } else {
            if (pq.isNotEmpty()) {
                val top = pq.poll()
                pq.offer(maxOf(top, cnt))
            }
        }
    }

    var cnt = 0
    while (pq.isNotEmpty()) {
        cnt += pq.poll()
    }
    print(cnt)
}