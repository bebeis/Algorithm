import java.util.*;
class Solution {
    
    public static boolean canChange(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        
        Map<String, Integer> distMap = new HashMap<>();
        for (String word : words) {
            distMap.put(word, 0);
        }
        distMap.put(begin, 0);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            
            for (String word : words) {
                if (!canChange(cur, word)) continue;
                if (distMap.get(word) != 0) continue;
                if (word.equals(target)) return distMap.get(cur) + 1;
                distMap.put(word, distMap.get(cur) + 1);
                queue.offer(word);
            }
        }
        return 0;
    }
}