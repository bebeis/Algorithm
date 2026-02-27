fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()

    val list = mutableListOf<Int>()
    for (i in 2..n) {
        if (i * i > n) break

        while (n % i == 0) {
            list.add(i)
            n /= i
        }
    }

    if (n != 1) list.add(n)
    print(list.joinToString("\n"))
}