// 틀린 이유: Int Overflow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val edges = mutableListOf<Triple<Int, Int, Long>>()

    for (i in 1..n) {
        with(readLine().split(" ").map { it.toLong() }) {
            for (j in i + 1..n) {
                edges.add(Triple(i, j, get(j - 1)))
            }
        }
    }
    edges.sortBy { it.third }

    val p = IntArray(n + 1) { -1 }

    fun find(x: Int): Int {
        if (p[x] < 0) return x
        p[x] = find(p[x])
        return p[x]
    }

    fun union(x: Int, y: Int): Boolean {
        var u = find(x)
        var v = find(y)

        if (u == v) return false
        if (p[u] > p[v]) u = v.also { v = u }

        p[u] += p[v]
        p[v] = u
        return true
    }

    var cnt = 0
    var sum = 0L
    for ((a, b, c) in edges) {
        if (cnt == n - 1) break

        if (union(a, b)) {
            cnt++
            sum += c
        }
    }

    print(sum)
}
