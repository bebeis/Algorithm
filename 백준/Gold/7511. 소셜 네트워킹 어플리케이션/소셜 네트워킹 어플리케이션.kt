import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val results = mutableListOf<String>()

    repeat(readLine().toInt()) {
        val sb = StringBuilder()
        val n = readLine().toInt()
        val k = readLine().toInt()

        val p = IntArray(n) { -1 }
        
        fun find(x: Int): Int {
            if (p[x] < 0) return x
            p[x] = find(p[x])
            return p[x]
        }

        fun union(x: Int, y: Int): Boolean {
            var u = find(x)
            var v = find(y)
            if (u == v) return false

            if (p[v] < p[u]) v = u.also { u = v }
            if (p[v] == p[u]) p[u]--
            p[v] = u
            return true
        }

        repeat(k) {
            val st = StringTokenizer(readLine())
            union(st.nextToken().toInt(), st.nextToken().toInt())
        }

        sb.append("Scenario ${it + 1}:\n")
        repeat(readLine().toInt()) {
            val st = StringTokenizer(readLine())
            if (find(st.nextToken().toInt()) == find(st.nextToken().toInt())) {
                sb.append("1\n")
            } else {
                sb.append("0\n")
            }
        }
        
        results.add(sb.toString())
    }

    print(results.joinToString("\n"))
}