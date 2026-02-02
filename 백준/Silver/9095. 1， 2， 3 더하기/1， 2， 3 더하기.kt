/**
 * 순서를 고려해서 경우의 수를 구함 -> 과거의 결과가 미래의 구성에 간섭이 없음
 */

fun main() = with(System.`in`.bufferedReader()) {
    val d = IntArray(11)
    d[0] = 1
    for (i in 1..10) {
        d[i] += (d[i - 1])
        if (i - 2 >= 0) d[i] += d[i - 2]
        if (i - 3 >= 0) d[i] += d[i - 3]
    }

    print(IntArray(readLine().toInt()) {
        d[readLine().toInt()]
    }.joinToString("\n"))
}