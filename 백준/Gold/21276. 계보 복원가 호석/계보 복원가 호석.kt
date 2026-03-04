import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val names = StringTokenizer(readLine()).let { st -> List(n) { st.nextToken() } }.sorted()
    val nameMap = mutableMapOf<String, Int>()
    names.withIndex().forEach { (idx, v) -> nameMap[v] = idx }

    val adj = Array(n + 1) { mutableListOf<Int>() }
    val indeg = IntArray(n + 1)

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val u = nameMap[st.nextToken()] ?: -1
        val v = nameMap[st.nextToken()] ?: -1
        adj[v] += u
        indeg[u]++
    }

    val rootIds = (0 until n).filter { indeg[it] == 0 }
    println(rootIds.size)
    println(rootIds.map { names[it] }.joinToString(" "))

    val childs = Array(n + 1) { TreeSet<Int>() }
    val queue = ArrayDeque<Int>()
    rootIds.forEach { queue.offer(it) }

    while (queue.isNotEmpty()) {
        var cur = queue.poll()

        for (nxt in adj[cur]) {
            if (--indeg[nxt] == 0) {
                childs[cur].add(nxt)
                queue.offer(nxt)
            }
        }
    }

    val sb = StringBuilder()
    for ((id, name) in names.withIndex()) {
        sb.append(name).append(' ').append(childs[id].size).append(' ')
        childs[id].forEach { sb.append(names[it]).append(' ') }
        sb.append('\n')
    }
    print(sb)
}