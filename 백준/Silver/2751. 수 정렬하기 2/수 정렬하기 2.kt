fun main() = with(System.`in`.bufferedReader()) {
    print(IntArray(readLine().toInt()) { readLine().toInt() }
        .sorted()
        .joinToString("\n"))
}