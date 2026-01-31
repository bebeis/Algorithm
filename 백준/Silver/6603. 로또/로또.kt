import java.util.*
/**
 * 1. 1~49중 k개의 숫자 고르기(주어짐)
 * 2. k개의 숫자 중 6개의 조합 나열하기
 * - 조합은 순서를 고려하면 안 됨
 * - 오름차순을 강제함으로써 순서 배제
 */

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val st = StringTokenizer(readLine())
        val k = st.nextToken().toInt()
        if (k == 0) break

        val arr = IntArray(k) { st.nextToken().toInt() }
        val numbers = IntArray(6)

        fun comb(startArrIdx: Int, curNumberIdx: Int) {
            if (curNumberIdx == 6)  {
                sb.append(numbers.joinToString(separator = " ", postfix = "\n"))
                return
            }
            
            for (arrIdx in startArrIdx until k) {
                numbers[curNumberIdx] = arr[arrIdx]
                comb(arrIdx + 1, curNumberIdx + 1)
            }
        }

        comb(0, 0)
        sb.append('\n')
    }
    print(sb)
}