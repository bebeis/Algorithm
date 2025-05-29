import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static char[][] board = new char[102][102];
    static int[][] dist = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(0, 0));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            var cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '0' || dist[nx][ny] > 0) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                queue.offer(new Pair(nx, ny));
            }
        }

        System.out.print(dist[n - 1][m - 1]);
    }

    static class Pair {
        int x; int y;
        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
}
