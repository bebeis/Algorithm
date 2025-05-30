import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Queue<Pair> queue = new ArrayDeque<>();
            int n = Integer.parseInt(br.readLine());
            int[][] dist = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) dist[i][j] = -1;
            }

            String[] parts = br.readLine().split(" ");
            Pair start = new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            queue.offer(start);
            dist[start.x][start.y] = 0;

            parts = br.readLine().split(" ");
            Pair target = new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

            while (!queue.isEmpty()) {
                var cur = queue.poll();
                if (cur.x == target.x && cur.y == target.y) {
                    System.out.println(dist[cur.x][cur.y]);
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (dist[nx][ny] != -1) continue;
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }
    }

    static class Pair {
        int x; int y;
        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
}
