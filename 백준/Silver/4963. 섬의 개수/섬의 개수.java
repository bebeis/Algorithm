import java.io.*;
import java.util.*;

/**
 * 가로, 세로, 대각선 가지는 연결된 걸로 본다.
 * 
 */

public class Main {

    static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1 ,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            int[][] board = new int[h + 1][w + 1];
            boolean[][] visited = new boolean[h + 1][w + 1];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == 0 || visited[i][j]) continue;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        var cur = queue.poll();

                        for (int d = 0; d < 8; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];

                            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                            if (board[nx][ny] == 0 || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
