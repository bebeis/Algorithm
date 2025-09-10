import java.io.*;
import java.util.*;

public class Main {
    static int[][][] mask = new int[5][5][5]; // [층][가로][세로]
    static int[] batchPos = new int[5];
    static boolean[] batchUsed = new boolean[5];
    final static int INF = 0x3f3f3f3f;
    static int[] dx = { 1, 0, -1, 0, 0, 0 };
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    static List<Pos> starts = new ArrayList<>();
    static int min = INF;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    mask[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        starts.add(new Pos(0, 0, 0));
        starts.add(new Pos(0, 4, 0));
        starts.add(new Pos(4, 0, 0));
        starts.add(new Pos(4, 4, 0));
        starts.add(new Pos(0, 0, 4));
        starts.add(new Pos(0, 4, 4));
        starts.add(new Pos(4, 0, 4));
        starts.add(new Pos(4, 4, 4));

        rotate(0);

        System.out.print(min == INF ? -1 : min);
    }

    public static void batchAndSolve() {
        int[][][] maze = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    maze[i][j][k] = mask[batchPos[i]][j][k];
                }
            }
        }

        for (Pos st : starts) {
            if (maze[st.x][st.y][st.z] == 0) continue;
            Pos dest = new Pos(4 - st.x, 4 - st.y, 4 - st.z);
            if (maze[dest.x][dest.y][dest.z] == 0) continue;

            int lb = Math.abs(st.x - dest.x) + Math.abs(st.y - dest.y) + Math.abs(st.z - dest.z);
            if (lb >= min) continue;

            ArrayDeque<Node> q = new ArrayDeque<>();
            boolean[][][] visited = new boolean[5][5][5];
            visited[st.x][st.y][st.z] = true;
            q.add(new Node(st.x, st.y, st.z, 0));

            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.d >= min) continue;
                if (cur.x == dest.x && cur.y == dest.y && cur.z == dest.z) {
                    min = Math.min(min, cur.d);
                    break;
                }
                for (int dir = 0; dir < 6; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    int nz = cur.z + dz[dir];
                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5) continue;
                    if (visited[nx][ny][nz]) continue;
                    if (maze[nx][ny][nz] == 0) continue;
                    visited[nx][ny][nz] = true;
                    q.add(new Node(nx, ny, nz, cur.d + 1));
                }
            }
            if (min == 12) return;
        }
    }

    public static void batch(int cur) {
        if (cur == 5) {
            batchAndSolve();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (batchUsed[i]) continue;
            batchPos[cur] = i;
            batchUsed[i] = true;
            batch(cur + 1);
            batchUsed[i] = false;
            if (min == 12) return;
        }
    }

    public static void rotate(int cur) {
        if (cur == 5) {
            Arrays.fill(batchUsed, false);
            batch(0);
            return;
        }

        for (int rot = 0; rot < 4; rot++) {
            if (rot > 0) rotateLayer90(cur);
            rotate(cur + 1);
            if (min == 12) return;
        }

    }

    public static void rotateLayer90(int layer) {
        int[][] tmp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tmp[j][4 - i] = mask[layer][i][j];
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mask[layer][i][j] = tmp[i][j];
            }
        }
    }

    static class Node {
        int x, y, z, d;
        Node(int x, int y, int z, int d) { this.x = x; this.y = y; this.z = z; this.d = d; }
    }

    static class Pos {
        int x, y, z;
        Pos(int x, int y, int z) { this.x = x; this.y = y; this.z = z; }
    }
}
