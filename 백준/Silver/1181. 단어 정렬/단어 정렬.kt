fun main() = with(System.`in`.bufferedReader()) {
    print(List(readLine().toInt()) { readLine() }
        .distinct()
        .sortedWith(compareBy<String> { it.length }.thenBy { it })
        .joinToString("\n"))
}