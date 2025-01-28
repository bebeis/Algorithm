import java.io.*;
import java.util.*;

// (2 + (3 * 3)) * 2

// 

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<String> stack = new ArrayDeque<>();
        boolean illegal = false;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == '(' || cur == '[') {
                stack.push(Character.toString(cur));
            } else {
                int sum = 0;
                if (stack.isEmpty()) {
                    illegal = true;
                    break;
                }
                while (!stack.isEmpty() && !stack.peek().equals("[") && !stack.peek().equals("(")) {
                    sum += Integer.parseInt(stack.peek());
                    stack.pop();
                }
                if (sum == 0) sum = 1;

                if (cur == ')') {
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        illegal = true;
                        break;
                    } else {
                        stack.pop();
                        stack.push(Integer.toString(2 * sum));
                    }
                } else {
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        illegal = true;
                        break;
                    } else {
                        stack.pop();
                        stack.push(Integer.toString(3 * sum));
                    }
                }
            }
        }
        int result = 0;
        for (String x : stack) {
            if (x.equals("[") || x.equals("]") || x.equals("(") || x.equals("]")) {
                illegal = true;
                break;
            }
            result += Integer.parseInt(x);
        }
        if (illegal) System.out.println(0);
        else System.out.println(result);
    }
}