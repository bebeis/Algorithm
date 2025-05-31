import java.io.*;
import java.util.*;

public class Main {

    static boolean[] yAxis = new boolean[17];
    static boolean[] leftDiag = new boolean[40];
    static boolean[] rightDiag = new boolean[40];

    static int n;
    static int cnt = 0;

    public static boolean canBatch(int x, int y) {
        if (yAxis[y]) return false;
        if (leftDiag[x + n - 1 - y]) return false;
        if (rightDiag[x + y]) return false;
        return true;
    }

    public static void backtracking(int cur) {
        if (cur == n) {
            cnt++;
            return;
        } 

        for (int j = 0; j < n; j++) {
            if (!canBatch(cur, j)) continue;
            yAxis[j] = true;
            leftDiag[cur + n - 1 - j] = true;
            rightDiag[cur + j] = true;
            backtracking(cur + 1);
            yAxis[j] = false;
            leftDiag[cur + n - 1 - j] = false;
            rightDiag[cur + j] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        backtracking(0);
        System.out.print(cnt);
    }
}
