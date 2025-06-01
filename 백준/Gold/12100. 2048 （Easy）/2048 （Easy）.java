import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static int[][] board = new int[22][22];
    static int[][] board2 = new int[22][22];
    static int max = 0;

    public static void updateMaxBlock() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, board2[i][j]);
            }
        }
    }

    public static void rotateSticker() {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - i - 1] = board2[i][j];
            }
        }
        board2 = result;
    }

    public static void move(int dir) {
        while (dir-- > 0) rotateSticker();
        boolean[][] merged = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (board2[i][j] == 0) continue;
                int idx = j - 1;        // 한 칸 왼쪽부터 검색
                boolean moved = false;
        
                // 1) 왼쪽으로 빈 칸이 있는지, 아니면 병합 대상이 있는지 탐색
                while (idx >= 0 && board2[i][idx] == 0) {
                    idx--;
                }
        
                // 2) idx가 -1이면 끝까지 빈 칸만 있었으므로, “맨 왼쪽(0칸)”으로 이동
                if (idx < 0) {
                    board2[i][0] = board2[i][j];
                    board2[i][j] = 0;
                    moved = (j != 0);
                }
                else {
                    // 3) idx가 0..n-1 까지 빈 칸이 아닌 블록을 가리키는 상태
                    if (board2[i][idx] == board2[i][j] && !merged[i][idx]) {
                        // 병합
                        board2[i][idx] *= 2;
                        merged[i][idx] = true;
                        board2[i][j] = 0;
                        moved = true;
                    }
                    else {
                        // 빈 칸이 아닌 블록이랑 값이 다르면, idx+1 위치로 한 칸만 이동
                        if (idx + 1 != j) {
                            board2[i][idx + 1] = board2[i][j];
                            board2[i][j] = 0;
                            moved = true;
                        }
                    }
                }
                // (moved 여부에 따라 0으로 덮거나, 덮지 않아도 되지만, 위에서 이미 처리함)
            }
        }
    }

    public static void run() {
        for (int tmp = 0; tmp < (1 << 10); tmp++) {
            for (int i = 0; i < n; i++) {
                board2[i] = board[i].clone();
            }
            int brute = tmp;
            for (int k = 0; k < 5; k++) {
                int dir = brute % 4;
                brute /= 4;
                move(dir);
            }
            updateMaxBlock();
        }
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
        run();
        System.out.print(max);

    }

    static class Pair {
        int x; int y;
        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
}
