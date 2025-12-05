import java.io.*;
import java.util.*;

/**
 * 문제: 격좌에서 목적지까지 도달하는 최단 이동 거리 구하기
 */

public class Main {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int n;
    static int m;
    static int[][] board = new int[102][102];
    static int[][] dist = new int[102][102];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            var cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 0 || dist[nx][ny] > 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        System.out.print(dist[n - 1][m - 1]);
    }
}
