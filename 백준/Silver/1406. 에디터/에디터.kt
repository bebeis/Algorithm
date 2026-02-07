import java.util.*
fun main() = with(System.`in`.bufferedReader()) {
    val leftList = LinkedList(readLine().toList())
    val rightList = LinkedList<Char>()

    repeat(readLine().toInt()) {
        readLine().run {
            when (this[0]) {
                'P' -> leftList.addLast(this[2])
                'L' -> leftList.removeLastOrNull() ?.let { rightList.addFirst(it) }
                'D' -> rightList.removeFirstOrNull() ?.let { leftList.addLast(it) }
                'B' -> leftList.removeLastOrNull()
            }
        }
    }

    print(leftList.joinToString("") + rightList.joinToString(""))
}