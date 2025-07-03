import java.io.*;
import java.util.*;

public class Main {

    static int m;
    static int n;
    static int k;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board = new int[102][102];
    static List<Integer> areas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // y
        n = Integer.parseInt(st.nextToken()); // x
        k = Integer.parseInt(st.nextToken());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int i = lx; i < rx; i++) {
                for (int j = ly; j < ry; j++) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) continue;
                Queue<Pair> queue = new ArrayDeque<>();
                int localArea = 1;
                queue.offer(new Pair(i, j));
                board[i][j] = 1;

                while (!queue.isEmpty()) {
                    var cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (board[nx][ny] != 0) continue;
                        board[nx][ny] = 1;
                        localArea++;
                        queue.offer(new Pair(nx, ny));
                    }
                }
                areas.add(localArea);
            }
        }

        Collections.sort(areas);
        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append('\n');
        areas.stream().forEach(i -> sb.append(i).append(' '));
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