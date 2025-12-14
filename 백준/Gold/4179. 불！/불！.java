import java.io.*;
import java.util.*;

/**
 * 문제: 미로 탈출
 * 조건: 장애물의 퍼짐
 */

class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;
    static int m;
    static char[][] board = new char[1002][1002];
    static int[][] fd = new int[1002][1002];
    static int[][] jd = new int[1002][1002];
    static Queue<int[]> FQ = new ArrayDeque<>();
    static Queue<int[]> JQ = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
                fd[i][j] = -1;
                jd[i][j] = -1;
                if (board[i][j] == 'F') {
                    FQ.offer(new int[]{i, j});
                    fd[i][j] = 0;
                }
                else if (board[i][j] == 'J') {
                    JQ.offer(new int[]{i, j});
                    jd[i][j] = 0;
                }
            }
        }
        int result = solve();
        System.out.print(result != -1 ? result : "IMPOSSIBLE");
    }

    private static int solve() {
        fireBFS();
        while (!JQ.isEmpty()) {
            var cur = JQ.poll();
            int nextDist = jd[cur[0]][cur[1]] + 1;
            if (cur[0] == 0 || cur[0] == n - 1 || cur[1] == 0 || cur[1] == m - 1) {
                return nextDist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#' || jd[nx][ny] != -1) continue;
                if (fd[nx][ny] != -1 && nextDist >= fd[nx][ny]) continue;
                jd[nx][ny] = nextDist;
                JQ.offer(new int[]{nx, ny});
            }
        }
        return -1;
    }

    private static void fireBFS() {
        while (!FQ.isEmpty()) {
            var cur = FQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#' || fd[nx][ny] != -1) continue;
                fd[nx][ny] = fd[cur[0]][cur[1]] + 1;
                FQ.offer(new int[]{nx, ny});
            }
        }
    }
}