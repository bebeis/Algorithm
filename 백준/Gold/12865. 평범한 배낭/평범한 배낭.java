import java.io.*;
import java.util.*;

// 구하고자 하는 것: 배낭에 넣을 수 있는 물건들의 가치 최댓값
/**
 * d[k] : 무게가 k일 때 물건들의 가치 최댓값
 * d[k] = max(d[k], d[k - w[i]] + v[i])
 * 무게가 k일 때 물건 가치가 최대가 아닐 수 있음.
 * 근데 이렇게 하면 물건들을 한 번씩 밖에 담지 못한다는 점을 만족시키지 못함.
 * 물건들을 담았는지 여부를 체크하는 방법 -> 물건마다 우리가 순서를 부여한다.
 * d[i][j] : i번까지 담을 수 있을 때, 무게가 j일 때 최대 가치
 * d[i][j]
 * 1. d[i - 1][j] 에서 i번을 담지 안는 케이스
 * 2. d[i - 1][j - w[i]]에서, i번을 담아 d[i][j]가 되는 케이스
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] d = new int[n + 1][k + 1];

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                d[i][j] = d[i - 1][j];
                if (j - w[i] >= 0) d[i][j] = Math.max(d[i][j], d[i - 1][j - w[i]] + v[i]);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                answer = Math.max(answer, d[i][j]);
            }
        }
        System.out.print(answer);
    }
}