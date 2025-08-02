import java.io.*;
import java.util.*;

public class Main {

    static int[][] board = new int[1002][1002];
    static boolean[][][] seen;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int n, m, k;

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

        seen = new boolean[n][m][k + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        seen[0][0][0] = true;

        int steps = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                int[] cur = queue.poll();
                int cx = cur[0], cy = cur[1], cb = cur[2];

                if (cx == n - 1 && cy == m - 1) {
                    System.out.print(steps);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d], ny = cy + dy[d];
                    if (isOutBoundary(nx, ny)) continue;

                    int nb = cb + (isNextWall(nx, ny) ? 1 : 0);
                    if (nb <= k && !seen[nx][ny][nb]) {
                        seen[nx][ny][nb] = true;
                        queue.add(new int[]{nx, ny, nb});
                    }
                }
            }
            steps++;
        }

        System.out.print(-1);
    }

    public static boolean isNextWall(int x, int y) {
        return board[x][y] == 1;
    }

    public static boolean isOutBoundary(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}
