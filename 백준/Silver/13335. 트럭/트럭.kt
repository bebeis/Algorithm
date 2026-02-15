/**
 * 조건
 * - 다리에는 최대 w개 트럭
 * - 다리위의 트럭 무게 합은 L 이하여야 함
 * - 순서변경 불가능
 * 
 * 출력: 모든 트럭이 다리를 건너는 최단시간
 * state: 다리 위의 트럭 무게합(전역), 다리 위에 있는 트럭들(입장 시간, queue)
 * * 시간을 1틱씩 증가시킴
 * 1. 기존에 있던 트럭들의 위치는 논리적으로 1씩 증가
 * - 만약 queue의 First가 다리위에서 탈출해야할 시기라면 탈출
 *   - 현재 시간과 입장 시간 비교
 *   - 탈출해야 한다면 poll(), 다리 위의 트럭 무게합 감소
 * 2. 새로운 트럭이 올라갈 수 있는지 판단
 * - 다리 위의 전체 무게합과 제한 무게를 비교
 *   - 가능하다면, 현재 시각을 queue에 offer
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, w, l) = readLine().split(" ").map { it.toInt() }
    val weights = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }

    var nextId = 0
    var weightSum = 0
    var curTime = 0
    val queue = ArrayDeque<Pair<Int, Int>>() // accessTime, weight
    while (true) {
        curTime++

        if (queue.isNotEmpty()) {
            val truck = queue.peek()
            if ((curTime - truck.first) == w) {
                queue.poll()
                weightSum -= truck.second
            }
        }

        if (nextId != n && weights[nextId] + weightSum <= l) {
            weightSum += weights[nextId]
            queue.offer(Pair(curTime, weights[nextId++]))
        }

        if (queue.isEmpty()) break;
    }

    print(curTime)
}