// 입력: 주사위 값을 담은 배열의 목록
// 출력: A가 골라야 하는 주사위 번호 목록(오름차순)
// 제한사항: 2 <= n <= 10, 짝수 | 원소는 1 ~ 100
// 승리 확률이 높아지도록 주사위를 구성하는 문제
// 1. 조합으로 주사위를 구성 (10C5)
class Solution {
    fun Int.hasbit(n: Int): Boolean = this and (1 shl n) != 0
    
    fun combinations(arr: IntArray, r: Int): List<List<Int>> {
        val n = arr.size
        return (0 until (1 shl n))
            .filter { it.countOneBits() == r }
            .map { mask -> (0 until n).filter { mask.hasbit(it) }.map { arr[it] } }
    }
    
    fun makeSumList(dice: Array<IntArray>, ids: List<Int>): ArrayList<Int> {
        val result = ArrayList<Int>()
        
        fun dfs(idx: Int, sum: Int) {
            if (idx == ids.size) {
                result.add(sum)
                return
            }
            
            val diceId = ids[idx]
            for (v in dice[diceId]) {
                dfs(idx + 1, sum + v)
            }
        }
        
        dfs(0, 0)
        return result
    }
    
    fun lowerbound(list: List<Int>, target: Int): Int {
        var lo = -1
        var hi = list.size
        
        while (lo + 1 < hi) {
            val mid = (lo + hi) / 2
            if (list[mid] >= target) hi = mid
            else lo = mid
        }
        return hi
    }
    
    fun solution(dice: Array<IntArray>): IntArray {
        val diceIds = IntArray(dice.size) { idx -> idx }
        val combs = combinations(diceIds, dice.size / 2)
        
        var maxWinningCount = 0
        var maxADiceIds: List<Int> = listOf()
        
        for (aDiceIds in combs) {
            val bDiceIds = diceIds.filter { !aDiceIds.contains(it) }
            
            // A, B에서 구해지는 합 결과 저장 리스트 
            val aSumList = makeSumList(dice, aDiceIds).sorted()
            val bSumList = makeSumList(dice, bDiceIds).sorted()
            
            var winningCount = 0
            for (aSum in aSumList) {
                winningCount += lowerbound(bSumList, aSum)
            }
            
            if (winningCount > maxWinningCount) {
                maxWinningCount = winningCount
                maxADiceIds = aDiceIds
            }
        }
        
        return maxADiceIds.sorted().map { it + 1 }.toIntArray()
    }
}