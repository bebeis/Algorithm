import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int s;
    static int[] arr = new int[22];
    static int cnt = 0;

    public static void backtracking(int cur, int sum) {
        if (cur == n) {
            if (sum == s) cnt++;
            return;
        }

        backtracking(cur + 1, sum + arr[cur]);
        backtracking(cur + 1, sum);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);
        if (s == 0) cnt--;
        System.out.print(cnt);
    }
}
