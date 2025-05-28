import java.util.*;
import java.io.*;
import java.util.stream.*;

// ), (, +-, */

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                sb.append(chars[i]);
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] == '*' || chars[i] == '/') {
                if (stack.peek() == '*' || stack.peek() == '/') {
                    sb.append(stack.pop());
                }
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] == '+' || chars[i] == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] == '(') {
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.print(sb);
    }
}
