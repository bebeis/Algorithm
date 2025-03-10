import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int dist[][] = new int[12][12];
    static boolean visited[] = new boolean[12];
    static int minDist = 0x3f3f3f3f;

    public static void backtracking(int cur, int sum, int cnt) {
        if (cnt == n) {
            if (sum < minDist) minDist = sum;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || i == cur) continue;
            visited[i] = true;
            backtracking(i, sum + dist[cur][i], cnt + 1);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        visited[k] = true;
        backtracking(k, 0, 1);

        System.out.print(minDist);

    }
}
