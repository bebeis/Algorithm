import java.io.*;
import java.util.*;

/**
 * O(n^2) or nmlogn까지
 * -> 전체를 스위핑 하고 끝나야 함. 이전의 상태를 바탕으로 -> 현재 결정: DP
 * d[i][j] : (i, j)가 꼭짓점으로 끝나는 정사각형의 길이
 * d[i][j] : 
 */
// 
public class Main {

    static char[][] board = new char[1002][1002];
    static int[][] d = new int[1002][1002];
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = input.charAt(j - 1);
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == '0') {
                    d[i][j] = 0;
                } else {
                    d[i][j] = Math.min(Math.min(d[i - 1][j - 1], d[i - 1][j]), d[i][j - 1]) + 1;
                }
                max = Math.max(d[i][j], max);
            }
        }
        System.out.print(max * max);
    }
}
