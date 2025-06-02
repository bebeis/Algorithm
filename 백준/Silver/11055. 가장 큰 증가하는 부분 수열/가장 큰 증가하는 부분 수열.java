import java.io.*;
import java.util.*;

public class Main {

    static int n;
    /**
     * 주의할 점!!!
     * 우리가 구하려고 하는거는 n에서의 증가하는 부분 수열의 최대 합이 아니고, 이 수열 전체에서의 최대 합
     * i번째를 포함했다면, arr[i]보다 작은 arr[k] 여러 개를 찾은 뒤, 그 중 최대를 찾는다.
     * O(n^2)
     */
    static int[] dp = new int[1002];
    static int[] arr = new int[1002];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int localMax = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) localMax = Math.max(localMax, dp[j]);
            }
            dp[i] = localMax + arr[i];
        }
        System.out.print(Arrays.stream(dp, 0, n).parallel().max().getAsInt());
    }
}
