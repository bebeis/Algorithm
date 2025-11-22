package P1406

import java.util.LinkedList

fun main() {
    val input = readlnOrNull()
    val list = LinkedList<Char>()
    input?.forEach { list.add(it) }

    val cursor = list.listIterator(list.size)

    val noArgCommands = mutableMapOf<String, () -> Unit>()
    val charCommands = mutableMapOf<String, (Char) -> Unit>()

    charCommands["P"] = { ch -> cursor.add(ch) }

    noArgCommands["L"] = {
        if (cursor.hasPrevious()) cursor.previous()
    }

    noArgCommands["D"] = {
        if (cursor.hasNext()) cursor.next()
    }

    noArgCommands["B"] = {
        if (cursor.hasPrevious()) {
            cursor.previous()
            cursor.remove()
        }
    }

    val n = readlnOrNull()?.toInt() ?: 0

    repeat(n) {
        val cmd = readlnOrNull() ?: ""
        val type = cmd[0]

        if (type == 'P') {
            val x = cmd[2]
            charCommands["P"]?.invoke(x)
        } else {
            noArgCommands[type.toString()]?.invoke()
        }
    }

    val sb = StringBuilder()
    list.forEach { sb.append(it) }
    print(sb)
}
