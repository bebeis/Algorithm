import java.util.*

// d[x]: x가 선택되었을 때, 가장 긴 수열의 길이
// d[x]: d[k] + 1 
// k는, arr[x] 보다 arr[k]가 작지만 d[k]가 가장 큰 것) -> 기존엔 O(n)이 었지만, 배열의 길이가 최대 100만 임으로 개선해야 함
// arr[k] < arr[i] 인 것 중에서 최대를 찾는다. O(1)이나 O(logn)이 필요하다. 
// 모노톤 스택? 이분탐색?을 생각해보자. 핵심은 오름차순이 유지되어야 한다.
// 값을 오름차순으로 저장하고, 인덱스를 길이로 사용한다 -> log 스케일로 탐색이 가능해진다.

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }
    val d = IntArray(n)
    val lv = IntArray(n + 1) // key: length, value: 해당 길이에서의 값

    d[0] = 1
    lv[1] = arr[0]
    var maxLength = 1

    fun lowerbound(target: Int): Int {
        var low = 0
        var high = maxLength + 1

        while (low + 1 < high) {
            val mid = (low + high) / 2
            if (lv[mid] >= target) high = mid
            else low = mid
        }

        return high
    }

    for (i in 1 until n) {
        if (arr[i] > lv[maxLength]) {
            d[i] = ++maxLength
            lv[maxLength] = arr[i]
        } else {
            val idx = lowerbound(arr[i])
            d[i] = idx
            lv[idx] = arr[i]
        }
    }

    print(maxLength)
}