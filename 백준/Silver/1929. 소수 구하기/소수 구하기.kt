fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val status = BooleanArray(m + 1) { true }
    status[1] = false
    val primes = mutableListOf<Int>()
    
    for (base in 2..m) {
        if (!status[base]) continue
        if (base * base > m) break
        for (ptr in base*base..m step base) {
            if (status[ptr]) status[ptr] = false
        }
    }

    for ((idx, ele) in status.withIndex()) {
        if (ele) primes.add(idx)
    }

    print(primes.filter { it >= n }.joinToString("\n"))
}