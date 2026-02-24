import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val nums = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }

    // +, - , x, ÷
    val opcnt = StringTokenizer(readLine()).let { st -> IntArray(4) { st.nextToken().toInt() } }
    val oparr = IntArray(n - 1)

    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE

    fun calculate() {
        val result = nums.drop(1).foldIndexed(nums[0]) { idx, acc, ele ->
            when (oparr[idx]) {
                0 -> acc + ele
                1 -> acc - ele
                2 -> acc * ele
                3 -> acc / ele
                else -> acc
            }
        }

        min = minOf(min, result)
        max = maxOf(max, result)
    }

    fun cfops(curIdx: Int) {
        if (curIdx == n - 1) {
            calculate()
            return
        }

        for (opId in 0..3) {
            if (opcnt[opId] == 0) continue

            opcnt[opId]--
            oparr[curIdx] = opId
            cfops(curIdx + 1)

            opcnt[opId]++
        }
    }

    cfops(0)
    println(max)
    println(min)
}