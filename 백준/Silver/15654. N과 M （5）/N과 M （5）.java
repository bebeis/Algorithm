import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] input = new int[10];
    static int[] arr = new int[10];
    static boolean[] isused = new boolean[10]; // 인덱스 저장
    static StringBuilder sb = new StringBuilder();

    public static void backtracking(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isused[i]) continue;
            isused[i] = true;
            arr[cur] = input[i];
            backtracking(cur + 1);
            isused[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input, 0, n);
        backtracking(0);
        System.out.print(sb);
    }
}
