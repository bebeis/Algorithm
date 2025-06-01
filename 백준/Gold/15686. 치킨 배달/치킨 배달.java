import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static int m;
    static int[][] board = new int[52][52];
    static boolean[] use = new boolean[52];
    static List<Pair> shops = new ArrayList<>();
    static List<Pair> homes = new ArrayList<>();
    static int min = 0x7f7f7f7f;

    public static void updateMinDist() {
        int dist = 0;
        for (var home: homes) {
            int tmp = 0x7f7f7f7f;
            for (int i = 0; i < shops.size(); i++) {
                if (!use[i]) continue;
                tmp = Math.min(tmp, Math.abs(shops.get(i).x - home.x) + Math.abs(shops.get(i).y - home.y));
            }
            dist += tmp;
        }
        min = Math.min(min, dist);
    }

    public static void backtracking(int cur, int last) {
        if (cur == m) {
            updateMinDist();
            return;
        }

        for (int i = last + 1; i < shops.size(); i++) {
            use[i] = true;
            backtracking(cur + 1, i);
            use[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    shops.add(new Pair(i, j));
                } else if (board[i][j] == 1) {
                    homes.add(new Pair(i, j));
                }
            }
        }
        backtracking(0, -1);
        System.out.print(min);
    }

    static class Pair {
        int x; int y;
        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
}
