import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    print(
        List(readLine().toInt()) {
            val st = StringTokenizer(readLine())
            Pair(st.nextToken().toInt(), st.nextToken())
        }.sortedWith(compareBy { it.first })
         .map { "${it.first} ${it.second}" }
         .joinToString("\n")
    )
}