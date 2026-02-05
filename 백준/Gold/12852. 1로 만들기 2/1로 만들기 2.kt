fun main() {
    val n = readln().toInt()
    val d = IntArray(n + 1)
    val before = IntArray(n + 1)

    for (i in 2..n) {
        d[i] = d[i - 1] + 1
        before[i] = i - 1

        if (i % 2 == 0) {
            val tmp = d[i / 2] + 1
            if (d[i] > tmp) {
                d[i] = tmp
                before[i] = i / 2
            }
        }

        if (i % 3 == 0) {
            val tmp = d[i / 3] + 1
            if (d[i] > tmp) {
                d[i] = tmp
                before[i] = i / 3
            }
        }
    }

    val sb = StringBuilder()
    var cur = n
    while (cur != 1) {
        sb.append(cur).append(' ')
        cur = before[cur]
    }
    sb.append(1)

    println(d[n])
    print(sb)
}