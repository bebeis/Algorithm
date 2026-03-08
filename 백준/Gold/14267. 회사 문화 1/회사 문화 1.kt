import java.util.*

/**
 * 상사 -> 부하 -> ... 칭찬 (칭찬 수치도)
 * 구하고자 하는 것: 칭찬을 각자 얼마나 받았는지 구하기
 * 
 * 조건
 * - n,m <= 100,000
 * - 문제: 매 칭찬마다 모든 자식을 타고가면 최악의 경우 O(nm) -> 시간 초과
 * - 칭찬을 받다보면, 자식을 타고가는게 중복됨 (점수는 달라지겠지만)
 * - 모든 칭찬 정보를 한 번 기록해두고, 한 번에 전파해내려가면 한 번의 스위핑으로 결과를 구할 수 있지 않을까?
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val childs = Array(n + 1) { mutableListOf<Int>() }
    val d = IntArray(n + 1)
    val st = StringTokenizer(readLine())
    st.nextToken()
    for (cur in 2..n) {
        val parent = st.nextToken().toInt()
        childs[parent].add(cur)
    }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val i = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        d[i] += w
    }

    val queue = ArrayDeque<Int>()
    queue.offer(1)

    while (queue.isNotEmpty()) {
        var cur = queue.poll()

        for (nxt in childs[cur]) {
            d[nxt] += d[cur]
            queue.offer(nxt)
        }
    }

    print(d.drop(1).joinToString(" "))
}