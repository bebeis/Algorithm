import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int h;
    static int[][][] board = new int[102][102][102];
    static int[][][] dist = new int[102][102][102];
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        Queue<Tuple> queue = new ArrayDeque<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    board[k][i][j] = Integer.parseInt(st.nextToken());
                    if (board[k][i][j] == 1) {
                        queue.offer(new Tuple(i, j, k));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            var cur = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
                if (board[nz][nx][ny] != 0) continue;
                dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
                board[nz][nx][ny] = 1;
                queue.offer(new Tuple(nx, ny, nz));
            }
        }

        System.out.print(findResult());

    }

    public static int findResult() {
        int max = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[k][i][j] == 0) {
                        return -1;
                    }
                    max = Math.max(max, dist[k][i][j]);
                }
            }
        }
        return max;
    }

    static class Tuple {
        int x;
        int y;
        int z;

        public Tuple(int xx, int yy, int zz) {
            x = xx;
            y = yy;
            z = zz;
        }
    }
}
