import java.io.*;
import java.util.*;
// m 원을 만들 수 있는 방법 수
/**
 * m 원을 만드는 케이스 
 * m - k 원에서 k원을 추가?
 * d[m] += d[m - k]; -> 순서로 인한 경우의 수가 뻥튀기됨
 * 구성의 관점에서 바라봐야 할 듯
 * 
 * 중요: 동전에 순서를 부여해서 과거의 경우의 수를 이용할 때, 순서로 인한 뻥튀기를 막는다.
 * i번째 동전을 사용하지 않고 금액을 구성한 경우 vs i번째 동전을 사용하고 구성한 경우로 나눈다.
 * 
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] costs = new int[n + 1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j - costs[i] < 0) continue;
                    dp[i][j] += dp[i][j - costs[i]];
                }
            }
            sb.append(dp[n][m]).append('\n');
        }
        System.out.print(sb);
    }
    
}
