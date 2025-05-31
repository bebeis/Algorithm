import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr = new int[10];
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void backtracking(int cur) {
        if (cur >= m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            arr[cur] = i;
            visited[i] = true;
            backtracking(cur + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        backtracking(0);
        System.out.print(sb);
    }
}
