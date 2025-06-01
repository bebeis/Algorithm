import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] dp = new int[1000002];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = n - 1; i >= 1; i--) {
            dp[i] = IntStream.of(dp[i + 1], (3 * i <= n) ? dp[3 * i] : 0x7f7f7f7f, (2 * i <= n) ? dp[2 * i] : 0x7f7f7f7f).min().getAsInt() + 1;
        }
        System.out.print(dp[1]);

    }
}
