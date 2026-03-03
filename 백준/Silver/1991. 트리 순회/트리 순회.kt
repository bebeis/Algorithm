import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val lc = IntArray(27)
    val rc = IntArray(27)

    repeat(n) {
        val (p, l, r) = readLine().split(" ").map { if (it == ".") -1 else it[0] - 'A' }
        lc[p] = l
        rc[p] = r
    }

    val sb = StringBuilder()

    fun preorder(cur: Int) {
        sb.append((cur + 'A'.code).toChar())
        if (lc[cur] != -1) preorder(lc[cur])
        if (rc[cur] != -1) preorder(rc[cur])
    }

    fun inorder(cur: Int) {
        if (lc[cur] != -1) inorder(lc[cur])
        sb.append((cur + 'A'.code).toChar())
        if (rc[cur] != -1) inorder(rc[cur])
    }

    fun postorder(cur: Int) {
        if (lc[cur] != -1) postorder(lc[cur])
        if (rc[cur] != -1) postorder(rc[cur])
        sb.append((cur + 'A'.code).toChar())
    }

    preorder(0)
    sb.append('\n')
    inorder(0)
    sb.append('\n')
    postorder(0)
    print(sb)
}