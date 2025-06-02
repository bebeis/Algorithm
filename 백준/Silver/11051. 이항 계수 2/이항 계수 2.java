import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[][] dp = new int[1002][1002];

    public static void main(String[] args) throws IOException {
        String[] parts = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        k = Integer.parseInt(parts[1]);
        // nCk = n-1Ck-1 + n-1Ck
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }
        System.out.print(dp[n][k]);
    }
}
