/**
 * 연결되지 않은 두 뉴런을 연결하거나 이미 연결된 두 뉴런의 연결을 끊는다.
 * 뉴런의 연결 정보가 주어졌을 때, 모든 뉴런을 하나의 트리 형태로 연결하기 위하여 필요한 최소 연산 횟수
 * - 뭉탱이 집합을 먼저 찾고
 * - 해당 집합을 연결해준다
 */
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        adj[u].add(v)
        adj[v].add(u)
    }

    val visited = BooleanArray(n + 1)
    var cnt = 0
    var remove = 0
    for (start in 1..n) {
        if (visited[start]) continue
        visited[start] = true
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.offer(start to -1)

        while (queue.isNotEmpty()) {
            var (cur, before) = queue.poll()

            for (nxt in adj[cur]) {
                if (visited[nxt]) {
                    if (nxt != before) {
                        remove++
                    }
                    continue
                }
                visited[nxt] = true
                queue.offer(nxt to cur)
            }
        }
        cnt++
    }

    print(cnt - 1 + remove / 2)
}