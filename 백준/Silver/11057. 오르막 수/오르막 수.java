import java.io.*;
import java.util.*;

/**
 * 인접한 수가 같아도 오름차순
 * 10,007로 나눈 나머지를 출력
 * 수는 0으로 시작할 수 있다.
 */

public class Main {

    static int n;
    static int[][] d = new int[1010][10];
    final static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        
        for (int i = 1; i <= 9; i++) d[i][i] = 1;

        for (int i = 1; i <= n + 9; i++) {
            d[i][0] = 1;
            for (int j = 1; j < Math.min(i, 10); j++)
            d[i][j] = (d[i - 1][j - 1] + d[i - 1][j]) % MOD;
        }

        System.out.print(d[n + 9][9]);
    }
}