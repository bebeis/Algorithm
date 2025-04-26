import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            int count = map.get(c) - 1;
            if (count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        
        return map.keySet().iterator().next();
    }
}