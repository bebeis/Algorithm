/**
 * 금액을 구성하는 모든 방법의 수: (금액, 방법)
 * - 금액은 10000원 이하, 동전의 수는 20개 이하
 * - 금액 x원: d[x] += d[x-coin[k]]
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val coins = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }
        val fin = readLine().toInt()
        val d = IntArray(fin + 1)

        // 이렇게 되면 순서가 영향을 미친다
        // for (money in 1..fin) {
        //     for (k in 0 until n) {
        //         if (money - coins[k] >= 0) d[money] += d[money - coins[k]]
        //     }
        // }

        // 사용할 수 있는 코인을 순차적으로 적용하면서, 구성에 집중한다.
        for (k in 0 until n) {
            if (coins[k] <= fin) d[coins[k]] += 1
            for (money in coins[k]+1..fin) {
                d[money] += d[money - coins[k]]
            }
        }
        println(d[fin])
    }
}