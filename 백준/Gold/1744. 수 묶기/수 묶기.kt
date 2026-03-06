import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val seqP = mutableListOf<Int>()
    val seqN = mutableListOf<Int>()
    var sum = 0

    repeat(n) {
        val num = readLine().toInt()
        if (num == 1) sum += num
        else if (num > 0) seqP.add(num)
        else seqN.add(num)
    }

    fun seqSum(seq: ArrayDeque<Int>) {
        while (seq.size > 1) {
            sum += seq.pollLast() * seq.pollLast()
        }

        if (seq.size == 1) {
            sum += seq.peekLast()
        }
    }

    seqP.sort()
    seqN.sortDescending()
    seqSum(ArrayDeque(seqP))
    seqSum(ArrayDeque(seqN))
    print(sum)
}