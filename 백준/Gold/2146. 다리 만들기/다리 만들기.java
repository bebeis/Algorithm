import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int islandId = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    labelIsland(i, j);
                    islandId++;
                }
            }
        }

        int minBridgeLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 1 && isBoundary(i, j)) {
                    int length = findShortestPath(i, j);
                    if (length != -1) {
                        minBridgeLength = Math.min(minBridgeLength, length);
                    }
                }
            }
        }

        System.out.println(minBridgeLength);
    }

    private static void labelIsland(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        board[x][y] = islandId;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (isValid(nx, ny) && board[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    board[nx][ny] = islandId;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static int findShortestPath(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0});
        
        boolean[][] localVisited = new boolean[n][n];
        localVisited[x][y] = true;
        int startIslandId = board[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int dist = current[2];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (!isValid(nx, ny) || localVisited[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] > 1 && board[nx][ny] != startIslandId) {
                    return dist;
                }

                if (board[nx][ny] == 0) {
                    localVisited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
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