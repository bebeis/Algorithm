import java.util.*;
import java.util.stream.*;

class Solution {
    
    public boolean check(long total, int n, int[] times) {
        return IntStream.of(times).mapToLong(time -> total / time).sum() >= n;
    }
    
    public long solution(int n, int[] times) {
        long minTime = Long.MAX_VALUE;
        for (int t : times) {
            if (t < minTime) minTime = t;
        }
        
        long st = 0, ed = minTime * (long) n;
        while (st + 1 < ed) {
            long mid = (st + ed) / 2;
            if (check(mid, n, times)) ed = mid;
            else st = mid;
        }
        return ed;
    }
}