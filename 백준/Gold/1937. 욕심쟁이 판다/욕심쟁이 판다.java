import java.io.*;
import java.util.*;

/**
 * O(n^3) or O(n^2logn)까지 가능
 * 한 번에 쓸면서 지나가는게 좋을 듯 -> DP
 * d[i][j] : d[i][j]까지 오는데 이동한 최대 거리
 * d[i][j] : Max(d[i - 1][j] d[i][j - 1], d[i + 1][j], d[i][j + 1]) + 1
 * 4방향이라, bottom up으로 채우는 순서가 애매함 -> Top Down
 * 시작은 최댓값에서?
 */


// 그 전 지역보다 옮긴 지역이 대나무가 많아야 함.
// 어디서 출발? 어디로 이동? -> 판다가 이동할 수 있는 칸의 수의 최댓값

public class Main {

    static int n;
    static int[][] board = new int[502][502];
    static int[][] d = new int[502][502];

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int dp(int cx, int cy) {
        if (d[cx][cy] != 0) {
            return d[cx][cy];
        }

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (board[cx][cy] <= board[nx][ny]) continue;
            int next = dp(nx, ny);
            d[cx][cy] = Math.max(d[cx][cy], next + 1);
        }

        return d[cx][cy];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == 0) {
                    dp(i, j);
                }
                max = Math.max(max, d[i][j]);
            }
        }

        System.out.print(max + 1);
    }

}
