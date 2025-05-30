import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static char[][] board = new char[1002][1002];
    static int[][] fireDist = new int[1002][1002];
    static int[][] personDist = new int[1002][1002];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 불에 타기전에 탈 수 있는지 여부
    // 얼마나 빨리 탈출할 수 있는지를 결정
    // 미로는 가장자리에서 탈출 가능
    // 벽 통과 불과
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        Queue<Pair> fireQueue = new ArrayDeque<>();
        Queue<Pair> personQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
                fireDist[i][j] = -1;
                personDist[i][j] = -1;
                if (board[i][j] == 'F') {
                    fireQueue.offer(new Pair(i, j));
                    fireDist[i][j] = 0;
                }
                else if (board[i][j] == 'J') {
                    personQueue.offer(new Pair(i, j));
                    personDist[i][j] = 0;
                }
            }
        }

        // 불 이동 거리 
        while (!fireQueue.isEmpty()) {
            var cur = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#' || fireDist[nx][ny] != -1) continue;
                fireDist[nx][ny] = fireDist[cur.x][cur.y] + 1;
                fireQueue.offer(new Pair(nx, ny));
            }
        }

        // 사람 이동
        while (!personQueue.isEmpty()) {
            var cur = personQueue.poll();
            if (cur.x == 0 || cur.x == n - 1 || cur.y == 0 || cur.y == m - 1) {
                System.out.print(personDist[cur.x][cur.y] + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#' || personDist[nx][ny] != -1 || (fireDist[nx][ny] != -1 && personDist[cur.x][cur.y] + 1 >= fireDist[nx][ny])) continue;
                personDist[nx][ny] = personDist[cur.x][cur.y] + 1;
                personQueue.offer(new Pair(nx, ny));
            }
        }
        System.out.print("IMPOSSIBLE");
    }

    static class Pair {
        int x; int y;
        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
}
