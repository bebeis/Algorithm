import java.util.*;
class Solution {
    
    public int[] solution(int n, int s) {
        int minValue = s / n;
        if (minValue == 0) return new int[]{-1};
        int cnt = s % n;
        int[] result = new int[n];
        for (int i = 0; i < n - cnt; i++) {
            result[i] = minValue;
        }
        
        for (int i = n - cnt; i < n; i++) {
            result[i] = minValue + 1;
        }
        
        return result;
    }
}