import java.io.*;
import java.util.*;

/**
 * 격좌에서 값의 전파
 * 문제: 전부다 전파되는데 몇일 걸리는지?
 * - 접근: 한 번 전파되면 그 곳은 신경쓰지 안아도 됨. 즉, 먼저 전파된게 최소 일수.
 */

public class Main {

    final static int INF = 0x3f3f3f3f;

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int n;
    static int m;
    static int[][] board = new int[1002][1002];
    static int[][] dist = new int[1002][1002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = INF;
                if (board[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            var cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == -1 || dist[nx][ny] != INF) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        System.out.print(result());
    }
    
    private static int result() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && dist[i][j] == INF) {
                    return -1;
                }
                if (board[i][j] != -1) {
                    max = Math.max(max, dist[i][j]);
                }
            }
        }
        return max;
    }
}
