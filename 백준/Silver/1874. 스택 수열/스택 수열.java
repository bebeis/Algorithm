import java.io.*;
import java.util.*;
import java.util.stream.*;

// 3 4

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int lastNum = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            while (stack.isEmpty() || stack.peek() < cur) {
                stack.push(++lastNum);
                sb.append("+\n");
            }

            if (stack.peek() != cur) {
                System.out.print("NO");
                System.exit(0);
            }

            stack.pop();
            sb.append("-\n");
        }
        System.out.print(sb);
    }
}
