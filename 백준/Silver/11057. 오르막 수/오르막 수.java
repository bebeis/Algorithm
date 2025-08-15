import java.io.*;
import java.util.*;

/**
 * 인접한 수가 같아도 오름차순
 * 10,007로 나눈 나머지를 출력
 * 수는 0으로 시작할 수 있다.
 */

public class Main {

    static int n;
    static int[][] d = new int[1002][10];
    final static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        Arrays.fill(d[1], 0, 10, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    d[i][j] = d[i - 1][j];
                    continue;
                }
                for (int k = 0; k <= j; k++) {
                    d[i][j] = (d[i][j] + d[i - 1][k]) % MOD;
                }
            }
        }

         System.out.print(Arrays.stream(d[n], 0, 10)
                           .reduce(0, (sum, val) -> (sum + val) % MOD));
    }
}