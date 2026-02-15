import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, w, l) = readLine().split(" ").map { it.toInt() }
    val weights = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }

    var weightSum = 0
    var curTime = 0
    val queue = ArrayDeque<Pair<Int, Int>>() // (enterTime, weight)

    for (i in 0 until n) {
        curTime++

        while (queue.isNotEmpty() && curTime - queue.peek().first >= w) {
            weightSum -= queue.poll().second
        }

        while (weights[i] + weightSum > l) {
            val front = queue.poll()
            curTime = front.first + w 
            weightSum -= front.second
            while (queue.isNotEmpty() && curTime - queue.peek().first >= w) {
                weightSum -= queue.poll().second
            }
        }

        weightSum += weights[i]
        queue.offer(curTime to weights[i])
    }

    print(curTime + w)
}