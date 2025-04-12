import java.io.*;
import java.util.*;

public class Main {

    // String Builder에 .append("\n") 빼먹어서 틀림

    static final int[] dx = {0, 0, 1, 0, -1, 0};
    static final int[] dy = {0, 0, 0, -1, 0, 1};
    static final int[] dz = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder();

        while (true) {
            int l, r, c;
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) break;

            Queue<Position> queue = new ArrayDeque<>();
            int[][][] dist = new int[l][r][c];
            char[][][] board = new char[l][r][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = line.charAt(k);
                        dist[i][j][k] = -1;
                        if (board[i][j][k] == 'S') {
                            queue.add(new Position(i, j, k));
                            dist[i][j][k] = 0;
                        }
                    }
                }
                br.readLine();
            }

            boolean isTrapped = true;
            while (!queue.isEmpty()) {
                var curPos = queue.poll();
                if (board[curPos.x][curPos.y][curPos.z] == 'E') {
                    sb.append("Escaped in ")
                    .append(dist[curPos.x][curPos.y][curPos.z])
                    .append(" minute(s).").append("\n");
                    isTrapped = false;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int nx = curPos.x + dx[i];
                    int ny = curPos.y + dy[i];
                    int nz = curPos.z + dz[i];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r || nz >= c) continue;
                    if (board[nx][ny][nz] == '#') continue;
                    if (dist[nx][ny][nz] != -1) continue;
                    dist[nx][ny][nz] = dist[curPos.x][curPos.y][curPos.z] + 1;
                    queue.add(new Position(nx, ny, nz));
                }
            }

            if (isTrapped) {
                sb.append("Trapped!").append("\n");
            }

        }

        System.out.print(sb);
    }

    static class Position {
        int x;
        int y;
        int z;

        public Position(int xx, int yy, int zz) {
            x = xx;
            y = yy;
            z = zz;
        }
    }
}