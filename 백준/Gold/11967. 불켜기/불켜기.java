import java.io.*;
import java.util.*;

/**
 * 어떤 방에는 다른 방의 불을 끄고 켤 수 있는 스위치가 달려있음
 * 불 켜져있는 방으로만 이동 가능. 상화좌우 가능
 */

/**
  * 틀린 이유 1.: 1-index 인데 초기화를 0-index로 해버림
  * 틀린 이유 2. lights 부분에서 visited 처리를 누락함
  */

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board = new int[102][102];
    // static int[][] lights = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static ArrayList<Pair>[][] buttons = new ArrayList[102][102];

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                buttons[i][j] = new ArrayList<>();
            }
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            buttons[cx][cy].add(new Pair(nx, ny));
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(1, 1));
        board[1][1] = 1;
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 1) {
                    queue.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }

            for (var btn : buttons[cur.x][cur.y]) {
                board[btn.x][btn.y] = 1;
                for (int d = 0; d < 4; d++) {
                    int nx = btn.x + dx[d];
                    int ny = btn.y + dy[d];
                    if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
                    if (visited[nx][ny] && !visited[btn.x][btn.y]) {
                        queue.add(new Pair(btn.x, btn.y));
                        visited[btn.x][btn.y] = true;
                        break;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += board[i][j];
            }
        }

        System.out.print(sum);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
}
