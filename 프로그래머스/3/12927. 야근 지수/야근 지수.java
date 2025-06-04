import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        while (n > 0) { // nlog(works.length)
            int max = pq.poll();
            if (max == 0) break;
            pq.offer(max - 1);
            n--;
        }
        return pq.stream().mapToLong(x -> x * x * 1L).sum();
    }
}