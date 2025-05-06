import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x : arr) {
            if (stack.isEmpty() || stack.peek() != x) {
                stack.push(x);
            }
        }
        
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
        
    }
}