import java.io.*;
import java.util.*;

public class Main {

    static int[][] board = new int[1002][1002];
    static int[][][] dist = new int[1002][1002][12];
    static final int INF = 0x3f3f3f3f;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;
    static int m;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        k = Integer.parseInt(parts[2]);

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], 0, k + 1, INF);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        dist[0][0][0] = 1;

        while (!queue.isEmpty()) {
            var cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cb = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isOutBoundary(nx, ny)) continue;
                if (isNextWall(nx, ny)) {
                    if (overBreakLimit(cb)) continue;
                    if (dist[cx][cy][cb] + 1 < dist[nx][ny][cb + 1]) {
                        dist[nx][ny][cb + 1] = dist[cx][cy][cb] + 1;
                        queue.offer(new int[]{nx, ny, cb + 1});
                    }
                } else {
                    if (dist[cx][cy][cb] + 1 < dist[nx][ny][cb]) {
                        dist[nx][ny][cb] = dist[cx][cy][cb] + 1;
                        queue.offer(new int[]{nx, ny, cb});
                    }
                }
            }
        }

        int minDist = INF;
        for (int i = 0; i <= k; i++) {
            minDist = Math.min(minDist, dist[n - 1][m - 1][i]);
        }

        System.out.print(minDist == INF ? -1 : minDist);
    }

    public static boolean isNextWall(int x, int y) {
        return board[x][y] == 1;
    }

    public static boolean isOutBoundary(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    public static boolean overBreakLimit(int b) {
        return b >= k;
    }
}
