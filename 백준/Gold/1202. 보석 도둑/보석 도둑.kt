import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val jewels = Array<Pair<Int, Int>>(n) { StringTokenizer(readLine()).run { nextToken().toInt() to nextToken().toInt() } }.sortedWith(compareByDescending { it.second })
    val bagMap = TreeMap<Int, Int>()
    repeat(k) {
        val weight = readLine().toInt()
        bagMap[weight] = bagMap.getOrDefault(weight, 0) + 1
    }

    var costSum = 0L
    for ((w, v) in jewels) {
        val bagEntry = bagMap.ceilingEntry(w)
        if (bagEntry == null) continue

        costSum += v
        if (bagEntry.value == 1) {
            bagMap.remove(bagEntry.key)
        } else {
            bagMap[bagEntry.key] = bagEntry.value - 1
        }
    }
    print(costSum)

}