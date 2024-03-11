import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m, count, min = 2500;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];

        char[][] whiteboard = { 
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, 
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, 
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, 
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, 
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, 
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, 
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, 
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'} 
        };

        char[][] blackboard = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, 
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, 
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, 
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, 
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, 
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, 
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        };
        
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // W 시작
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                count = 0;
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if (board[i + x][j + y] != whiteboard[x][y]) {
                            count++;
                        }
                    }
                }
                if (count < min) {
                    min = count;
                }
            }
        }

        // B 시작
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                count = 0;
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if (board[i + x][j + y] != blackboard[x][y]) {
                            count++;
                        }
                    }
                }
                if (count < min) {
                    min = count;
                }
            }
        }
        System.out.print(min);
    }
}