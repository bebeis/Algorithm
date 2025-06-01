import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] dp = new int[12];
            int n = Integer.parseInt(br.readLine());
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                dp[i] += dp[i - 1];
                if (i - 2 >= 0) dp[i] += dp[i - 2];
                if (i - 3 >= 0) dp[i] += dp[i - 3];
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}
