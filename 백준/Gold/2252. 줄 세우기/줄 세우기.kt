import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val indeg = IntArray(n + 1)
    val graph = List(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        indeg[b]++
    }

    val queue: Queue<Int> = LinkedList()
    for (i in 1..n) {
        if (indeg[i] == 0) {
            queue.offer(i)
        }
    }

    val sb = StringBuilder()
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        sb.append(cur).append(' ')

        for (nxt in graph[cur]) {
            if (--indeg[nxt] == 0) {
                queue.offer(nxt)
            }
        }
    }

    print(sb)
}
