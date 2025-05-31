import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] board = new int[10][10];
    static int[][] board2 = new int[10][10];
    static List<Pair> cctvs = new ArrayList<>();
    static int min = 100;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 1. 단방향. case = 4
    // 2. 2방향(직선) case = 2
    // 3. 2방향(수직) case = 4
    // 4. 3방향 case = 4
    // 5. 4방향 case = 1
    
    // 8 ^ 4 = 2^12 X 2 ^ 3 x 2 ^ 3 = 2 ^ 18

    public static int findHiddenArea() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board2[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void fill(Pair cur, int dir) {
        dir %= 4;
        int x = cur.x;
        int y = cur.y;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (x < 0 || x >= n || y < 0 || y >= m || board2[x][y] == 6) return;
            if (board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int mn = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 6 && board[i][j] != 0) {
                    cctvs.add(new Pair(i, j));
                }
                if (board[i][j] == 0) mn++;
            }
        }

        for (int tmp = 0; tmp < (1 << 2 * cctvs.size()); tmp++) {
            for (int i = 0; i < n; i++) {
                board2[i] = board[i].clone();
            }
            int brute = tmp;
            for (Pair cctv : cctvs) {
                int dir = brute % 4;
                brute /= 4;
    
                if (board[cctv.x][cctv.y] == 1) {
                    fill(cctv, dir);
                } else if (board[cctv.x][cctv.y] == 2) {
                    fill(cctv, dir);
                    fill(cctv, dir + 2);
                } else if (board[cctv.x][cctv.y] == 3) {
                    fill(cctv, dir);
                    fill(cctv, dir + 1);
                } else if (board[cctv.x][cctv.y] == 4) {
                    fill(cctv, dir);
                    fill(cctv, dir + 1);
                    fill(cctv, dir + 2);
                } else {
                    fill(cctv, dir);
                    fill(cctv, dir + 1);
                    fill(cctv, dir + 2);
                    fill(cctv, dir + 3);
                }
            }

            mn = Math.min(mn, findHiddenArea());
        }
        System.out.print(mn);
    }
    
    static class Pair {
        int x; int y;
        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
}
