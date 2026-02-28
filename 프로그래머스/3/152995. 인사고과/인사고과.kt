class Solution {
    fun solution(scores: Array<IntArray>): Int {
        val targetA = scores[0][0]
        val targetB = scores[0][1]
        val targetSum = targetA + targetB

        for (i in 1 until scores.size) {
            val a = scores[i][0]
            val b = scores[i][1]
            if (targetA < a && targetB < b) return -1
        }

        val sorted = scores.sortedWith(
            compareByDescending<IntArray> { it[0] }.thenBy { it[1] }
        )

        val eligible = ArrayList<IntArray>(sorted.size)
        var maxY = -1
        for (s in sorted) {
            val y = s[1]
            if (y < maxY) continue
            eligible.add(s)
            if (y > maxY) maxY = y
        }

        var better = 0
        for (s in eligible) {
            if (s[0] + s[1] > targetSum) better++
        }
        return better + 1
    }
}