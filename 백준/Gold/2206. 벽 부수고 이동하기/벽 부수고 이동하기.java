import java.io.*;
import java.util.*;

/**
 * 가장 심플한 아이디어 : 벽 하나를 임의로 제거한 다음, 최단 거리를 구한다. -> O(n^4) 불가능
 * 상태 유지 아이디어 : 큐에 벽을 부수고 이동하는지 여부를 같이 저장한다. 
 * -> 특정 지점에서 최단거리 기록할 때 벽 부순 유무 저장 
 * -> 복잡
 *  d[n][m] = (0,0) -> (벽) + (벽) -> (n, m)
 * 1. 벽을 부수지 않는다고 가정하고 모든 지점까지의 최단 거리를 구한다. O(n^2)
 * 2. 벽에서 출발했을 때, 최단 거리 구하기
 */

public class Main {

    static char[][] board = new char[1002][1002];
    static int[][] dist = new int[1002][1002];
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                dist[i][j] = -1;
            }
        }

        Queue<Pair> queue = new ArrayDeque<>();
        Queue<Pair> wallQueue = new ArrayDeque<>();
        queue.offer(new Pair(0, 0));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            var cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;

                if (board[nx][ny] == '1') wallQueue.offer(new Pair(nx, ny));
                else queue.offer(new Pair(nx, ny));
            }
        }

        while (!wallQueue.isEmpty()) {
            var cur = wallQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '1') continue;
                if (dist[nx][ny] != -1 && dist[nx][ny] <= dist[cur.x][cur.y] + 1) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                wallQueue.offer(new Pair(nx, ny));
            }
        }

        System.out.print(dist[n - 1][m - 1]);
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