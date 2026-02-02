/**
 * 한 번에 한 계단 or 두 계단
 * 연속된 세 계단 불가능
 * 이 게임에서 얻을 수 있는 총 점수의 최댓값 구하기
 */

/**
 * i 번째 계단에 도달하는 경우
 * 1. d[i] = d[i - 2] + a[i]
 * 2. d[i] = d[i - 3] + a[i - 1] + a[i]
 */
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val a = IntArray(n + 1) { idx -> if (idx == 0) 0 else readLine().toInt() }
    val d = IntArray(n + 1)

    d[1] = a[1]
    if (n >= 2) d[2] = a[1] + a[2]
    for (i in 3..n) {
        d[i] = maxOf(d[i - 2] + a[i], d[i - 3] + a[i - 1] + a[i])
    }

    print(d[n])
}