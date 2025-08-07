import java.io.*;
import java.util.*;

public class Main {

    final static int MAX_COUNT = 6;
    static int[] s;
    static int k;
    static int[] d;
    static StringBuilder sb = new StringBuilder();

    public static void backtracking(int cnt, int last) {
        if (cnt == MAX_COUNT) {
            for (int i = 0; i < MAX_COUNT; i++) {
                sb.append(d[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = last + 1; i < k; i++) {
            d[cnt] = s[i];
            backtracking(cnt + 1, i);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            s = new int[k];
            d = new int[6];

            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            backtracking(0, -1);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
