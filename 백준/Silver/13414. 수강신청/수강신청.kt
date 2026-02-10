fun main() = with(System.`in`.bufferedReader()) {
    val (k, l) = readLine().split(" ").map { it.toInt() }
    val reqs = LinkedHashSet<String>()
    repeat(l) {
        val stu = readLine()
        if (reqs.contains(stu)) {
            reqs.remove(stu)
        }
        reqs.add(stu)
    }

    print(reqs.take(k).joinToString("\n"))
}