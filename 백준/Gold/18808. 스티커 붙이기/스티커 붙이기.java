import java.io.*;
import java.util.*;

public class Main {

    // 1. 무회전, 가장 위쪽, 왼쪽부터
    // 2. 불가능하면 시계방향 90도 회전 -> 다시 붙이기 시도 -> 90도 회전 -> ...
    // 3. 270도까지 회전했는데 못붙이면 버림.

    static int n, m;
    static int k;
    static int[][] board = new int[42][42];

    public static boolean attachSticker(int[][] paper, int r, int c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // i, j부터 채우기 시도
                if (i + r > n || j + c > m) continue;

                // 채울 수 있는지 검사
                boolean canAttach = true;
                for (int x = 0; x < r; x++) {
                    for (int y = 0; y < c; y++) {
                        if (paper[x][y] == 1 && board[i + x][j + y] == 1) {
                            canAttach = false;
                            break;
                        }
                    } if (!canAttach) break;
                }

                if (!canAttach) continue;
                
                // 채우기
                for (int x = 0; x < r; x++) {
                    for (int y = 0; y < c; y++) {
                        if (paper[x][y] == 1) board[i + x][j + y] = 1;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static int[][] rotateSticker(int[][] origin, int r, int c) {
        // 기존에 (x, y) -> (y, r - x - 1)
        int[][] result = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[j][r - i - 1] = origin[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] paper = new int[r + 2][c + 2];

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 0도 시도
            if (attachSticker(paper, r, c)) continue;

            // 90도 회전
            paper = rotateSticker(paper, r, c);
            int tmp = r; r = c; c = tmp;

            // 90도에서 시도
            if (attachSticker(paper, r, c)) continue;

            // 180도 회전
            paper = rotateSticker(paper, r, c);
            tmp = r; r = c; c = tmp;

            // 180도에서 시도
            if (attachSticker(paper, r, c)) continue;

            // 270도 회전
            paper = rotateSticker(paper, r, c);
            tmp = r; r = c; c = tmp;

            // 270도에서 시도
            if (attachSticker(paper, r, c)) continue;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) cnt++;
            }
        }
        System.out.print(cnt);
    }
}
