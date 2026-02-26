import java.util.*

infix fun Int.on(i: Int): Int = this or (1 shl i - 1)
infix fun Int.off(i: Int): Int = this and (1 shl i - 1).inv()
fun Int.back(): Int = (this shl 1).off(21)
fun Int.front(): Int = this shr 1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val trains = IntArray(n)

    repeat(m) {
        val st = StringTokenizer(readLine())
        val command = st.nextToken().toInt()
        val target = st.nextToken().toInt() - 1

        when (command) {
            1 -> trains[target] = trains[target] on st.nextToken().toInt()
            2 -> trains[target] = trains[target] off st.nextToken().toInt()
            3 -> trains[target] = trains[target].back()
            4 -> trains[target] = trains[target].front()
        }
    }
    print(trains.toSet().size)
}