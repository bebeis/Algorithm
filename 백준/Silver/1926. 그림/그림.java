import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int[][] arr = new int[502][502];
    static boolean[][] visited = new boolean[502][502];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    static int maxArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 || visited[i][j]) continue;

                Queue<Pair> queue = new ArrayDeque<>();
                int area = 1;
                queue.offer(new Pair(i, j));
                visited[i][j] = true;
                cnt++;
                
                while (!queue.isEmpty()) {
                    var cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (arr[nx][ny] == 0 || visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        queue.offer(new Pair(nx, ny));
                        area++;
                    }
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        System.out.println(cnt);
        System.out.print(maxArea);
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
