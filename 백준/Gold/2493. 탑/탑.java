import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static int[] arr = new int[500002];
    static int[] result = new int[500002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Pair> stack = new ArrayDeque<>();
        for (int i = n; i >= 1; i--) {
            if (stack.isEmpty()) {
                stack.push(new Pair(arr[i], i));
                continue;
            }

            while (!stack.isEmpty() && stack.peek().val <= arr[i]) {
                Pair top = stack.pop();
                result[top.idx] = i;
            }
            stack.push(new Pair(arr[i], i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.print(sb);
    }

    // 자바 15에도 record는 못쓰네..
    static class Pair {
        final int val;
        final int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
