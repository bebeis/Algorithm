import java.io.*;
import java.util.*;

/**
 * Goal : 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하는 것
 * Sol) : 그리디한 방법, DP 처럼 부분해를 재사용하거나, 이런게 보이지 않는다. 모든 조합을 다 계산해보자
 * 1. n명을 두 팀으로 나눈다. (최대 20C10, O(2^n) 2^20 => 최대 180,000)
 * 2. 각 팀에서 능력치를 구한다. O(n^2, 최대 200)
 * 3. 두 팀의 능력치 차이를 구한다.
 * 만약 비트마스킹을 쓴다면, INT 하나로 전부 표현 가능
 */

public class Main {

    static int[][] d = new int[22][22];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = 0x3f3f3f3f;
        for (int i = 1; i < (1 << n); i++) {
            if (Integer.bitCount(i) != n / 2) continue;
            int start = 0;
            int link = 0;
            for (int x = 0; x < 20; x++) {
                for (int y = 0; y < 20; y++) {
                    if (x == y) continue;
                    int bitX = ((i >> x) & 1);
                    int bitY = ((i >> y) & 1);
                    if (bitX == 1 && bitY == 1) {
                        start += d[x][y];
                    }
                    if (bitX == 0 && bitY == 0) {
                        link += d[x][y];
                    }
                }
            }
            min = Math.min(min, Math.abs(start - link));
        }
        System.out.print(min);
    }
}