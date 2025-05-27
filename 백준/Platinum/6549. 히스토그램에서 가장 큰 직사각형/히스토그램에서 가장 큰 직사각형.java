import java.io.*;
import java.util.*;

// 모노톤 스택에서 stack pop할 때 외부 상태를 바꾸는 등의 동작이 발생할 수도 있다.

public class Main {

    static int[] arr = new int[100002];

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long max = 0;
            if (n == 0) break;
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    int idx = stack.pop();
                    long height = arr[idx];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    long width = i - left - 1;
                    max = Math.max(max, height * width);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int idx = stack.pop();
                long height = arr[idx];
                int left = stack.isEmpty() ? -1 : stack.peek();
                long width = n - left - 1;
                max = Math.max(max, height * width);
            }

            sb.append(max).append('\n');
        }
        System.out.print(sb);
    }
}