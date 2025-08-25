import java.io.*;
import java.util.*;

/**
 * m개의 우주
 * 우주마다 N개 행성
 * 모든 쌍의 대소관계가 두 행성끼리 같은 경우만 평행 == ai번째의 랭킹과 bi번째의 랭킹이 동일하다 == 좌표압축 결과가 동일하다
 * 구성이 같은데 순서만 다른 우주의 쌍은 한 번만 센다.
 * 
 * 정렬
 * O(mnlogn) : 4,000,000
 * 탐색
 * O(m^2 * n) :     
 * 
 */

public class Main {

    static int m;
    static int n;
    static int[][] sz = new int[102][10002];
    static int[][] compressed = new int[102][10002];

    public static int[][] sorted = new int[102][];

    public static int lowerBound(int target, int pnum) {
        int lo = -1, high = sorted[pnum].length;
        while (lo + 1 < high) {
            int mid = (lo + high) / 2;
            if (sorted[pnum][mid] < target) lo = mid;
            else high = mid;
        }
        return high;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sz[i][j] = Integer.parseInt(st.nextToken());
            }
            sorted[i] = Arrays.stream(sz[i], 0, n).sorted().distinct().toArray();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                compressed[i][j] = lowerBound(sz[i][j], i);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                boolean same = true;
                for (int k = 0; k < n; k++) {
                    if (compressed[i][k] != compressed[j][k]) {
                        same = false;
                        break;
                    }
                }
                if (same) cnt++;
            }
        }

        System.out.print(cnt);

    }
}
