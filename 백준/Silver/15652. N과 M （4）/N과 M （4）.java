import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void backtracking(int cur, int last) {
        if (cur == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = last; i <= n; i++) {
            arr[cur] = i;
            backtracking(cur + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        String[] parts = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");

        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        backtracking(0, 1);
        System.out.print(sb);
    }
}
