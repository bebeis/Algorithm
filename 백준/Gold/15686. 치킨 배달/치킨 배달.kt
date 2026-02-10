import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } } }

    val chickens = mutableListOf<Pair<Int, Int>>()
    val homes = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (board[i][j] == 1) {
                homes.add(i to j)
            } else if (board[i][j] == 2) {
                chickens.add(i to j)
            }
        }
    }

    val result = (1 until (1 shl chickens.size)).filter { it.countOneBits() == m }
        .minOf { status -> 
            val selected = chickens.filterIndexed { i, _ -> status and (1 shl i) != 0 }
            homes.sumOf { home -> selected.minOf { chicken -> Math.abs(home.first - chicken.first) + Math.abs(home.second - chicken.second) }}
        }
    print(result)
}