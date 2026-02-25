import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(compareByDescending<Int>{it})
    repeat(readLine().toInt()) {
        val cur = readLine().toInt()
        if (maxHeap.isEmpty()) {
            maxHeap.offer(cur)
            sb.append("$cur\n")
        } else if (minHeap.isEmpty()) {
            val midUpperOne = maxHeap.peek()
            if (midUpperOne > cur) {
                maxHeap.poll()
                minHeap.offer(midUpperOne)
                maxHeap.offer(cur)
            } else {
                minHeap.offer(cur)
            }
            val mid = maxHeap.peek()
            sb.append("$mid\n")
        } else {
            val originMid = maxHeap.peek()
            if (cur > originMid) {
                if (minHeap.size < maxHeap.size) {
                    minHeap.offer(cur)
                } else {
                    minHeap.offer(cur)
                    maxHeap.offer(minHeap.poll())
                }
            } else {
                if (minHeap.size < maxHeap.size) {
                    maxHeap.offer(cur)
                    minHeap.offer(maxHeap.poll())
                } else {
                    maxHeap.offer(cur)
                }
            }
            val mid = maxHeap.peek()
            sb.append("$mid\n")
        }
    }
    print(sb)
}