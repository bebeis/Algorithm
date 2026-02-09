import java.util.*
fun main() = with(System.`in`.bufferedReader()) {
    val (n, s) = readLine().split(" ").map {it.toInt()}.let {it[0] to it[1]}
    val arr = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }
    print((1 until (1 shl n)).filter { status ->
        arr.filterIndexed { i, _ -> status and (1 shl i) != 0 }.sum() == s
    }.count())
}