import java.io.*;
import java.util.*;

/**
 * 알고리즘 로직은 다 맞았는데, 마지막에 결과 출력하는 부분에서 실수함
 */

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] hx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] board = new int[202][202];
    static int[][][] dist = new int[202][202][32];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dist[i][j], 0, 31, -1);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        dist[0][0][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int ck = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (board[nx][ny] == 1) continue;
                if (dist[nx][ny][ck] == -1 || dist[nx][ny][ck] > dist[cx][cy][ck] + 1) {
                    dist[nx][ny][ck] = dist[cx][cy][ck] + 1;
                    queue.offer(new int[]{nx, ny, ck});
                }
            }
            if (ck >= k) continue;
            for (int i = 0; i < 8; i++) {
                int nx = cx + hx[i];
                int ny = cy + hy[i];
                int nk = ck + 1;

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (board[nx][ny] == 1) continue;
                if (dist[nx][ny][nk] == -1 || dist[nx][ny][nk] > dist[cx][cy][ck] + 1) {
                    dist[nx][ny][nk] = dist[cx][cy][ck] + 1;
                    queue.offer(new int[]{nx, ny, nk});
                }
            }
        }

        int result = -1;
        for (int i = 0; i <= k; i++) {
            int d = dist[h - 1][w - 1][i];
            if (result == -1) {
                if (d != -1) {
                    result = d;
                }
            } else { // result != -1
                if (d != -1) {
                    result = Math.min(result, d);
                }
            }
        }
        System.out.print(result);
    }
}
