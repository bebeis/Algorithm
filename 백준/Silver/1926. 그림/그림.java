import java.io.*;
import java.util.*;

/**
 * 문제: 격좌에서 영역의 수/넓이 구하기
 */

class Main {

    static int[][] board = new int[502][502];
    static boolean[][] visited = new boolean[502][502];
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxArea = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || board[i][j] == 0) continue;
                cnt++;
                int area = bfs(i, j);
                maxArea = Math.max(maxArea, area);
            }
        }
        System.out.println(cnt);
        System.out.println(maxArea);
    }

    public static int bfs(int sx, int sy) {
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            var cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] == 0) continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        return cnt;
    }
}