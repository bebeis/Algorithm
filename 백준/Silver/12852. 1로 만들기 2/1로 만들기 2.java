import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int n;
    static int[] dp = new int[1000002];
    static int[] pre = new int[1000002];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // d[i] = (d[i / 3], d[i / 2], d[i - 1]);
        dp[1] = 0; pre[1] = 0;
        for (int i = 2; i <= n; i++) {
            int min = IntStream.of(dp[i - 1], (i % 3 == 0) ? dp[i / 3] : 0x7f7f7f7f, (i % 2 == 0) ? dp[i / 2] : 0x7f7f7f7f).min().getAsInt();
            if (i % 3 == 0 && dp[i / 3] == min) {
                pre[i] = i / 3;
            } else if (i % 2 == 0 && dp[i / 2] == min) {
                pre[i] = i / 2;
            } else {
                pre[i] = i - 1;
            }
            dp[i] = min + 1;
        }
        sb.append(dp[n]).append('\n');
        while (n >= 1) {
            sb.append(n).append(' ');
            n = pre[n];
        }
        System.out.print(sb);
    }
}
