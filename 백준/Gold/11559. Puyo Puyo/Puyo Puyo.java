import java.io.*;
import java.util.*;

public class Main {

    static char[][] board = new char[12][6];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static boolean gameResult() {
        boolean bomb = false;
        boolean[][] visited = new boolean[12][6];
        
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] == '.' || visited[i][j]) continue;
                Queue<Pair> queue = new ArrayDeque<>();
                List<Pair> pairs = new ArrayList<>();
                queue.offer(new Pair(i, j));
                pairs.add(new Pair(i, j));
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    var cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                        if (board[nx][ny] != board[cur.x][cur.y] || visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        queue.offer(new Pair(nx, ny));
                        pairs.add(new Pair(nx, ny));
                    }
                }
                if (pairs.size() >= 4) {
                    for (var pair : pairs) {
                        board[pair.x][pair.y] = '.';
                    }
                    bomb = true;
                }
            }
        }
        return bomb;
    }

    public static void moveDown() {
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                int target = i;
                while (target + 1 <= 11 && board[target + 1][j] == '.') target++;
                board[target][j] = board[i][j];
                if (target != i) board[i][j] = '.';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int cnt = 0;
        while (gameResult()) {            
            cnt++;
            moveDown();
        }
        System.out.print(cnt);
    }

    static class Pair {
        int x; int y;
        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
}
