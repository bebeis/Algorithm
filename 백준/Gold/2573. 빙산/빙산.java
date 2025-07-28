import java.io.*;
import java.util.*;

// 한 덩어리 빙산이 주어질 때, 두 덩어리 이상으로 분리되는 최초 시간?
/**
 * 최대 10년걸림
 * 0. 매 년마다 루프
 * 1. 둘러싼 빙하에 맞게 높이를 update
 *  - 근접 빙하가 영향을 주면 안 됨. 아래 빙하가 3 -> 0 바뀌고, 인접한 내가 3을 0으로 취급하면 안 됨
 * 2. 빙하의 분리 유무 파악
 *  - 분리 되었을 시, 상태 update 및 loop break;
 * 3. 출력
 */

/**
 * 실수한 부분
 * 모두 녹았을 때 == 0이든 <0이든 일관성 있게 저장해야 했는데 그렇지 못함.
 * 문제 조건을 잘못 읽어서 최대 10년이라고 오해함
 */
public class Main {

    static int n;
    static int m;
    static int[][] board = new int[302][302];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void update() {
        Deque<Change> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) continue;

                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (board[nx][ny] <= 0) cnt++;
                }

                if (cnt != 0) stack.push(new Change(i, j, Math.max(board[i][j] - cnt, 0)));
            }
        }

        while (!stack.isEmpty()) {
            var cur = stack.pop();
            board[cur.x][cur.y] = cur.val;
        }
    }

    public static boolean isSeparated() {
        int cnt = 0;
        boolean[][] visited = new boolean[302][302];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || visited[i][j]) continue;
                Queue<Pair> queue = new ArrayDeque<>();
                queue.offer(new Pair(i, j));
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    var cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (board[nx][ny] == 0 || visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        queue.offer(new Pair(nx, ny));
                    }
                }
                cnt++;
                if (cnt >= 2) return true;
            }
        }
        return false;
    }

    public static boolean allMelted() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) return false;
            }
        }
        return true;
    }


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

        int takeTime = 0;
        while (true) {
            takeTime++;
            update();
            if (isSeparated()) {
                break;
            }

            if (allMelted()) {
                takeTime = 0;
                break;
            }
        }
        System.out.print(takeTime);
    }

    static class Change {
        int x;
        int y;
        int val;

        public Change(int xx, int yy, int vv) {
            x = xx;
            y = yy;
            val = vv;
        }
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