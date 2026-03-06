/**
 * 뒤에 지금보다 비싸지는 순간 존재 O -> buy
 * 뒤에 지금보다 비싸지는 순간 존재 X -> 다팔기
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val arr = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() }}

        val nearTop = IntArray(n)
        nearTop[n - 1] = arr[n - 1]
        for (i in n-1 downTo 1) {
            if (arr[i - 1] <= nearTop[i]) nearTop[i - 1] = nearTop[i]
            else nearTop[i - 1] = arr[i - 1]
        }

        var stack = ArrayDeque<Int>()
        var earn = 0L
        for ((day, cur) in arr.withIndex()) {
            if (cur < nearTop[day]) stack.push(cur)
            else if (cur == nearTop[day]){
                while (stack.isNotEmpty()) {
                    earn += (cur - stack.poll())
                }
            }
        }
        println(earn)
    }
}