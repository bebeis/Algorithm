import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int n;
    static int[] arr = new int[1000002];
    static int[] tmp = new int[1000002];

    // 1, 2, 3, 3, 3, 3 4, 5
    // F F T T T T T T
    // F F F F F F T T

    public static int compress(int target) {
        int st = -1, ed = tmp.length;
        while (st + 1 < ed) {
            int mid = (st + ed) / 2;
            if (tmp[mid] >= target) ed = mid;
            else st = mid;
        }
        return ed;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tmp, 0, n);
        tmp = Arrays.stream(tmp, 0, n).distinct().toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(compress(arr[i])).append(' ');
        }
        System.out.print(sb);
    }
}
