fun main() = with(System.`in`.bufferedReader()) {
    IntArray(readLine().toInt()) { readLine().toInt() }
        .sortedDescending()
        .mapIndexed { idx, value -> (idx + 1) * value }
        .max()
        .let(::print)
}