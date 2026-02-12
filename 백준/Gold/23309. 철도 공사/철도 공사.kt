import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = StringTokenizer(readLine()).run { nextToken().toInt() to nextToken().toInt() }
    val arr = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }
    val prev = IntArray(1_000_001)
    val next = IntArray(1_000_001)
    for ((idx, id) in arr.withIndex()) {
        prev[id] = arr[(idx - 1 + n) % n]
        next[id] = arr[(idx + 1) % n]
    }
    val sb = StringBuilder()

    repeat(m) {
        val st = StringTokenizer(readLine())
        when (st.nextToken()) {
            "BN" -> {
                val i = st.nextToken().toInt()
                val j = st.nextToken().toInt()
                val ni = next[i]
                sb.append(ni).append('\n')
                next[i] = j; prev[ni] = j
                prev[j] = i; next[j] = ni
            }
            "BP" -> {
                val i = st.nextToken().toInt()
                val j = st.nextToken().toInt()
                val pi = prev[i]
                sb.append(pi).append('\n')
                prev[i] = j; next[pi] = j
                prev[j] = pi; next[j] = i
            }
            "CN" -> {
                val i = st.nextToken().toInt()
                val target = next[i]
                sb.append(target).append('\n')
                next[i] = next[target]
                prev[next[target]] = i
            }
            "CP" -> {
                val i = st.nextToken().toInt()
                val target = prev[i]
                sb.append(target).append('\n')
                prev[i] = prev[target]
                next[prev[target]] = i
            }
        }
    }
    print(sb)
}