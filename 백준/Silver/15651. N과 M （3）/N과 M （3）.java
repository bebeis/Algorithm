import java.io.*;
import java.util.*;

public class Main {

    // 자바로 백트리킹 sout -> 무조건 sb에 담아서 1번만, 안그러면 시스템 콜 많이 나가서 느려진다.

    static int n, m;
    static int[] d = new int[10];
    static StringBuilder sb = new StringBuilder();
    public static void backtracking(int cur) {
        if (cur >= m) {
            for (int i = 0; i < m; i++) {
                sb.append(d[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            d[cur] = i;
            backtracking(cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        backtracking(0);
        System.out.print(sb);
    }
}