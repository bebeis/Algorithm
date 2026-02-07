import java.util.*
fun main() = with(System.`in`.bufferedReader()) {
    val list = LinkedList(readLine().toList())
    val iter = list.listIterator(list.size)

    repeat(readLine().toInt()) {
        readLine().run {
            when (this[0]) {
                'P' -> iter.add(this[2])
                'L' -> if (iter.hasPrevious()) iter.previous()
                'D' -> if (iter.hasNext()) iter.next()
                'B' -> if (iter.hasPrevious()) { iter.previous(); iter.remove() }
            }
        }
    }

    print(list.joinToString(""))
}