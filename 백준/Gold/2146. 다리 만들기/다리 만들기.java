import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] board; 
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandId = 2; // 0: 바다, 1: 미확인 땅, 2부터는 섬 ID
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    labelIsland(i, j, islandId, visited);
                    islandId++;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 1 && isBoundary(i, j)) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0; 
                }
            }
        }

        int minBridgeLength = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isValid(nx, ny)) continue;

                if (board[nx][ny] > 1 && board[nx][ny] != board[x][y]) {
                    minBridgeLength = Math.min(minBridgeLength, dist[x][y] + dist[nx][ny]);
                }
                
                if (board[nx][ny] == 0) { 
                    board[nx][ny] = board[x][y];
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        System.out.println(minBridgeLength);
    }
    
    private static void labelIsland(int x, int y, int id, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        board[x][y] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (isValid(nx, ny) && board[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    board[nx][ny] = id;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean isBoundary(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny) && board[nx][ny] == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}