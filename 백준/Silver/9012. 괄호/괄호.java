import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            Deque<Character> stack = new ArrayDeque<>();
            String input = br.readLine();
            boolean fail = false;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    stack.push('(');
                    continue;
                }
                if (stack.isEmpty() || stack.peek() != '(') {
                    fail = true;
                    break;
                }
                stack.pop();
            }
            if (!stack.isEmpty()) fail = true;
            sb.append(fail ? "NO" : "YES").append('\n');
        }
        System.out.print(sb);
    }
}
