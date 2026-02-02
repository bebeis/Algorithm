fun main() {
    val n = readln().toInt()
    val d = IntArray(n + 1)

    d[1] = 0
    for (i in 2..n) {
        d[i] = d[i - 1] + 1
        if (i % 2 == 0) d[i] = minOf(d[i], d[i / 2] + 1)
        if (i % 3 == 0) d[i] = minOf(d[i], d[i / 3] + 1)
    }
    print(d[n])
}