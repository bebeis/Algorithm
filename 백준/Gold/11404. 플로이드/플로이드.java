import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    final static int INF = 0x3f3f3f3f;
    static int dist[][] = new int[101][101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 1, n + 1, INF);
            dist[i][i] = 0;
        }

        while (m-- > 0) {
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);
            dist[u][v] = Math.min(dist[u][v], w);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) sb.append(0);
                else sb.append(dist[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}