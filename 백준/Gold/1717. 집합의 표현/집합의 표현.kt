package com.lannstark.boj

import java.util.StringTokenizer

/**
 * 연산의 종류 두 가지
 * 1. 합집합
 * 2. 같은 집합에 두 원소가 포함되어 있는지 검사
 */

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val (n, m) = listOf(st.nextToken().toInt(), st.nextToken().toInt())
    val p = IntArray(n + 1, { -1 })

    fun find(x: Int): Int {
        if (p[x] < 0) {
            return x
        }

        p[x] = find(p[x])
        return p[x]
    }

    fun union(x: Int, y: Int): Boolean {
        var u = find(x)
        var v = find(y)

        if (u == v) {
            return false
        }

        if (u > v) u = v.also { v = u }
        if (p[u] == p[v]) p[u]--

        p[v] = u
        return true
    }

    val sb = StringBuilder()

    val unionCommand = { a: Int, b: Int -> union(a, b)}
    val queryCommand = { a: Int, b: Int -> if (find(a) == find(b)) sb.append("YES\n") else sb.append("NO\n")}

    val commandMap = mapOf(0 to unionCommand, 1 to queryCommand)
    repeat(m) {
        with(StringTokenizer(readLine())) {
            commandMap[nextToken().toInt()]?.invoke(nextToken().toInt(), nextToken().toInt())
        }
    }

    print(sb)
}
