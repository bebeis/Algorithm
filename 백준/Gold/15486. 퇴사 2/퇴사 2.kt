import java.util.*

/**
 * 상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익(마지막에 완료하지 못하는 경우에 유의)

 * - 가중치가 있어서 그리디한 접근은 불가능
 * - i번째 날 선택하면, 미래가 결정됨
 * - 현재가 미래를 결정하는데, 미래는 과거의 영향을 받지 않으므로 미래를 결정해도 괜찮을 듯
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val t = IntArray(n + 1)
    val p = IntArray(n + 1)
    val d = IntArray(n + 2)

    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        t[i] = st.nextToken().toInt()
        p[i] = st.nextToken().toInt()
    }

    for (i in 1..n) {
        d[i] = maxOf(d[i], d[i - 1]) // 선택 안한 경우도 고려해줘야 함
        if (i + t[i] > n + 1) continue
        d[i + t[i]] = maxOf(d[i + t[i]], d[i] + p[i])
    }

    print(d.max())
}