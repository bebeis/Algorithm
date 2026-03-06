/**
 * 3월부터 11월까지 매일 꽃이 펴있어야 함
 * 꽃의 수를 최대한 적게 유지
 */

import java.util.*

data class Date(
    val month: Int,
    val date: Int,
) : Comparable<Date> {

    override fun compareTo(other: Date): Int {
        if (month == other.month) return date.compareTo(other.date)
        return month.compareTo(other.month)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val flowers = mutableListOf<Pair<Date, Date>>()
    repeat(n) {
        val st = StringTokenizer(readLine())
        val start = Date(st.nextToken().toInt(), st.nextToken().toInt())
        val end = Date(st.nextToken().toInt(), st.nextToken().toInt())
        flowers.add(start to end)
    }
    flowers.sortWith(compareBy<Pair<Date, Date>> { it.first })

    var cnt = 0
    var toStartDate = Date(3, 1)
    var tempMaxDate = toStartDate
    for (flower in flowers) {
        if (toStartDate < flower.first) {
            if (tempMaxDate == toStartDate) {
                // println("이전 종료 시점 이내에 시작하는 노드가 없음")
                println(0)
                return@with
            }

            toStartDate = tempMaxDate
            if (toStartDate >= Date(12, 1)) break
            cnt++
        }

        if (flower.first <= toStartDate) {
            if (flower.second > toStartDate) {
                tempMaxDate = maxOf(tempMaxDate, flower.second)
            }
        }
    }

    if (tempMaxDate <= Date(11, 30)) {
        // println("마지막 노드가 11월 30일 이전임")
        println(0)
        return@with
    }

    println(cnt + 1)
}