import java.util.*;
import java.util.stream.*;

class Solution {
    
    public List<Integer> findCandidate(String[] user_id, String maskingId) {
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < user_id.length; j++) {
            String user = user_id[j];
            if (user.length() != maskingId.length()) continue;
            boolean state = true;
            for (int i = 0; i < user.length(); i++) {
                if (maskingId.charAt(i) == '*') continue;
                if (user.charAt(i) != maskingId.charAt(i)) {
                    state = false;
                    break;
                }
            }
            if (state) result.add(j);
        }
        return result;
    }
    
    Set<String> set = new HashSet<>();
    
    public void backtracking(int cur, boolean[] used, String[] user_id, String[] banned_id) {
        if (cur == banned_id.length) {
            set.add(IntStream.range(0, user_id.length)
                .filter(i -> used[i])
                .mapToObj(i -> user_id[i])
                .collect(Collectors.joining(" ")));
            return;
        }
        
        List<Integer> candidates = findCandidate(user_id, banned_id[cur]);
        for (int candidate : candidates) {
            if (used[candidate]) continue;
            used[candidate] = true;
            backtracking(cur + 1, used, user_id, banned_id);
            used[candidate] = false;
        }
        
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] used = new boolean[user_id.length];
        backtracking(0, used, user_id, banned_id);
       
        return set.size();
    }
}