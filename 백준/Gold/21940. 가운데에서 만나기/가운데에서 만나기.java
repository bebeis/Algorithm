import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int d[][] = new int[202][202];
    static final int INF = 0x3f3f3f3f;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) d[i][j] = INF;
            d[i][i] = 0;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            d[u][v] = Math.min(cost, d[u][v]);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) d[i][j] = d[i][k] + d[k][j];
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> homes = new ArrayList<>();
        while (k-- > 0) {
            homes.add(Integer.parseInt(st.nextToken()));
        }

        // 준형이와 친구들의 왕복시간 들 중 최대가 최소가 되는 도시

        int minMaxTime = INF;
        List<Integer> targets = new ArrayList<>();
        for (int t = 1; t <= n; t++) {
            int maxTime = -1;
            boolean skip = false;
            for (Integer home : homes) {
                if (d[t][home] == INF || d[home][t] == INF) {
                    skip = true;
                    break;
                }
                maxTime = Math.max(maxTime, d[t][home] + d[home][t]);
            }

            if (skip) continue;
            if (minMaxTime > maxTime) {
                minMaxTime = maxTime;
                targets = new ArrayList<>();
                targets.add(t);
            } else if (minMaxTime == maxTime) {
                targets.add(t);
            }
        }

        Collections.sort(targets);
        for (Integer target : targets) {
            System.out.print(target + " ");
        }
    }
}
