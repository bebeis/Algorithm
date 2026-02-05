import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val meetings = MutableList(readLine().toInt()) { 
        StringTokenizer(readLine()).run() {
            nextToken().toInt() to nextToken().toInt()
        }
    }

    meetings.sortWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
    var curTime = 0;
    var cnt = 0;
    for ((idx, meeting) in meetings.withIndex()) {
        if (meeting.first < curTime) continue
        curTime = meeting.second
        cnt++
    }
    print(cnt)
}