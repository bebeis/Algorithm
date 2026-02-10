import java.util.*
fun main() = with(System.`in`.bufferedReader()) {
    val persons = mutableSetOf<String>()

    repeat(readLine().toInt()) {
        val (name, command) = StringTokenizer(readLine()).let { it.nextToken() to it.nextToken() }
        if (command == "enter") {
            persons.add(name)
        } else if (command == "leave") {
            persons.remove(name)
        }
    }

    print(persons.sortedDescending().joinToString("\n"))
}