import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(reverseOrder())

    repeat(readLine().toInt()) {
        val cur = readLine().toInt()

        if (maxHeap.isEmpty() || cur <= maxHeap.peek()) maxHeap.offer(cur)
        else minHeap.offer(cur)

        if (maxHeap.size > minHeap.size + 1) minHeap.offer(maxHeap.poll())
        else if (minHeap.size > maxHeap.size) maxHeap.offer(minHeap.poll())

        sb.appendLine(maxHeap.peek())
    }
    print(sb)
}