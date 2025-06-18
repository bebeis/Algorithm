import java.io.*;
import java.util.*;

public class Main {

    // 최대 O(n^3)
    // a -> b 까지 직접적인 길이 없어도 우회해서 갈 수 있음
    // 길이 여러 개 있을 수도 있음 -> 최단 경로를 알아야 함.
    // ASP를 구해서 수색 범위 인지 파악 -> 아이템 개수 파악

    static int n, m, r;
    static int itemCounts[] = new int[103];
    static int dist[][] = new int[103][103];
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 1, n + 1, INF);
            dist[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCounts[i] = Integer.parseInt(st.nextToken());
        }

        while (r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int maxCnt = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= m) {
                    cnt += itemCounts[j];
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.print(maxCnt);
    }
}