import java.io.*;
import java.util.*;

/**
 * 이전 : 모든 건물들이 어떻게든 연결되어 있음
 * 이후 : 일방 통행만 가능한 길로 바뀐 곳 존재
 * 일방 통행인 길 중 양방향으로 바꿔야하는 길을 조사
 * 건물들 사이를 잇는 길들을 모두 조사해서, 일방통행만 가능한지 양방향 가능한지 조사
 * st, ed 주어지면 몇 개의 길을 양방향으로 바꿔야하는건지?
 */

public class Main {

    static int n;
    static int m;
    static int[][] d = new int[252][252];

    final static int INF = 0x3f3f3f3f;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = INF;
            }
            d[i][i] = 0;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            d[u][v] = 0;
            if (b == 1) {
                d[v][u] = 0;
            } else {
                d[v][u] = 1;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(d[s][e]).append('\n');
        }
        System.out.print(sb);
    }
}