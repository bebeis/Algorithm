fun main() = with(System.`in`.bufferedReader()) {
    val full = readLine()
    val sub = readLine()

    var cnt = 0
    var lastIdx = 0
    while (true) {
        val indexHead = full.indexOf(sub, lastIdx)
        if (indexHead == -1) break;

        cnt++
        lastIdx = indexHead + sub.length
    }
    print(cnt)
}
