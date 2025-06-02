import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr = new int[100002];

    public static boolean check(int idx, int target) {
        if (arr[idx] < target) return false;
        return true;
    }

    // 1, 2, 3, 4, 5

    public static int binarySearch(int target) {
        int st = -1, ed = n;
        while (st + 1 < ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] >= target) ed = mid;
            else st = mid;
        }
        if (ed < n && arr[ed] == target) return 1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 0, n);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(cur)).append('\n');
        }
        System.out.print(sb);
    }
}
