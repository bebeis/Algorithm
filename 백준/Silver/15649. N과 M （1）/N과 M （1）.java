import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] d = new int[10];
    static boolean[] used = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void backtracking(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(d[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            used[i] = true;
            d[cnt] = i;
            backtracking(cnt + 1);
            used[i] = false;
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
