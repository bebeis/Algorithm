import java.io.*
import java.util.*
import kotlin.math.*

const val NOT_SEARCHED = 0
const val IN_CYCLE = 1
const val OUT_CYCLE = -1

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val arrows = IntArray(n + 1)
        val results = IntArray(n + 1) { NOT_SEARCHED }

        with(StringTokenizer(readLine())) {
            for (i in 1..n) arrows[i] = nextToken().toInt()
        }

        val visitedStamp = IntArray(n + 1) { 0 }
        var stamp = 0

        fun searchFromFirst(firstIdx: Int) {
            stamp++ // 이번 탐색 고유 id

            var curIdx = firstIdx
            visitedStamp[curIdx] = stamp
            var nxtIdx = arrows[firstIdx]

            fun visitedInThisRun(x: Int) = (visitedStamp[x] == stamp)

            while (results[nxtIdx] == NOT_SEARCHED && !visitedInThisRun(nxtIdx)) {
                curIdx = nxtIdx
                visitedStamp[curIdx] = stamp
                nxtIdx = arrows[curIdx]
            }

            // 이미 결과가 나온 곳에 낑기려는 경우
            if (results[nxtIdx] != NOT_SEARCHED) {
                curIdx = firstIdx
                nxtIdx = arrows[firstIdx]
                results[curIdx] = OUT_CYCLE

                while (results[nxtIdx] == NOT_SEARCHED) {
                    curIdx = nxtIdx
                    results[curIdx] = OUT_CYCLE
                    nxtIdx = arrows[curIdx]
                }
                return
            }

            // 사이클이 탐지된 경우
            if (visitedInThisRun(nxtIdx)) {
                val entryPoint = nxtIdx
                curIdx = firstIdx

                while (curIdx != entryPoint) {
                    results[curIdx] = OUT_CYCLE
                    curIdx = arrows[curIdx]
                }

                results[curIdx] = IN_CYCLE
                curIdx = arrows[curIdx]

                while (curIdx != entryPoint) {
                    results[curIdx] = IN_CYCLE
                    curIdx = arrows[curIdx]
                }
            }
        }

        for (i in 1..n) {
            if (results[i] != NOT_SEARCHED) continue
            searchFromFirst(i)
        }

        val cnt = results.count { it == OUT_CYCLE }
        sb.append(cnt).append('\n')
    }
    print(sb)
}
