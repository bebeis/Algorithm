import java.io.*;
import java.util.*;

public class Main {
    
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            char[][] board = new char[1002][1002];
            int fireDist[][] = new int[1002][1002];
            int personDist[][] = new int[1002][1002]; 
            Queue<Pair> queue = new ArrayDeque<>();

            String[] parts = br.readLine().split(" ");
            Pair start = null;
            int w = Integer.parseInt(parts[0]);
            int h = Integer.parseInt(parts[1]);
            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = input.charAt(j);
                    fireDist[i][j] = -1;
                    personDist[i][j] = -1;
                    
                    if (board[i][j] == '@') {
                        start = new Pair(i, j);
                        personDist[i][j] = 0;
                    } else if (board[i][j] == '*') {
                        queue.offer(new Pair(i, j));
                        fireDist[i][j] = 0;
                    }
                }
            }
            // 불 도착 시간 측정
            while (!queue.isEmpty()) {
                var cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (board[nx][ny] == '#' || fireDist[nx][ny] != -1) continue;
                    fireDist[nx][ny] = fireDist[cur.x][cur.y] + 1;
                    queue.offer(new Pair(nx, ny));
                }
            }

            String result = "IMPOSSIBLE";
            queue.offer(start);
            while (!queue.isEmpty()) {
                var cur = queue.poll();

                if (cur.x == h - 1 || cur.y == w - 1 || cur.x == 0 || cur.y == 0) {
                    result = String.valueOf(personDist[cur.x][cur.y] + 1);
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (board[nx][ny] == '#' || personDist[nx][ny] != -1) continue;
                    if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= personDist[cur.x][cur.y] + 1) continue;
                    personDist[nx][ny] = personDist[cur.x][cur.y] + 1;
                    queue.offer(new Pair(nx, ny));
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
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
