import java.io.*;
import java.util.*;

class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int m;
    static int n;
    static char[][] board;
    static int[][] fd;
    static int[][] pd;
    static Queue<int[]> fq;
    static Queue<int[]> pq;
    final static int[] dx = { 1, 0, -1, 0 };
    final static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            testcase();
        }
        System.out.print(sb);
    }

    private static void testcase() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        fd = new int[n][m];
        pd = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
                fd[i][j] = -1;
                pd[i][j] = -1;
            }
        }
        sb.append(solve()).append('\n');
    }

    private static String solve() {
        fq = new ArrayDeque<>();
        pq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '@') {
                    pq.add(new int[]{i, j});
                    pd[i][j] = 0;
                } else if (board[i][j] == '*') {
                    fq.add(new int[]{i, j});
                    fd[i][j] = 0;
                }
            }
        }
        fireBFS();
        int result = personBFS();

        if (result == -1) return "IMPOSSIBLE";
        return String.valueOf(result);
    }

    private static void fireBFS() {
        while (!fq.isEmpty()) {
            var cp = fq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cp[0] + dx[i];
                int ny = cp[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#') continue;
                if (fd[nx][ny] != -1) continue;
                fd[nx][ny] = fd[cp[0]][cp[1]] + 1;
                fq.offer(new int[]{nx, ny});
            }
        }
    }

    private static int personBFS() {
        while (!pq.isEmpty()) {
            var cp = pq.poll();
            int nd = pd[cp[0]][cp[1]] + 1;
            if (cp[0] == 0 || cp[0] == n - 1 || cp[1] == 0 || cp[1] == m - 1) {
                return nd;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cp[0] + dx[i];
                int ny = cp[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#') continue;
                if (fd[nx][ny] != -1 && fd[nx][ny] <= nd) continue;
                if (pd[nx][ny] != -1) continue;

                pd[nx][ny] = nd;
                pq.offer(new int[]{nx, ny});
            }
        }

        return -1;
    }
}