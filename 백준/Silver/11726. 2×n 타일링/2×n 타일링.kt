// 10007로 나누기 빼먹어서 틀림
fun main() {
    val n = readln().toInt()

    val d = IntArray(n + 1)
    d[1] = 1
    if (n >= 2) d[2] = 2
    for (i in 3..n) {
        d[i] = (d[i - 2] + d[i - 1]) % 10_007
    }
    print(d[n])
}