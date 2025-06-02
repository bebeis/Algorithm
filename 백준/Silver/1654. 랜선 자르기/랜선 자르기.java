import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int k;
    static int n;
    static long[] arr = new long[1000002];

    public static boolean check(long length) {
        return Arrays.stream(arr, 0, k).map(x -> x / length).sum() >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        k = Integer.parseInt(parts[0]);
        n = Integer.parseInt(parts[1]);

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long st = 1; // true
        long ed = Arrays.stream(arr, 0, k).max().getAsLong() + 1; // false
        while (st + 1 < ed) {
            long mid = st + (ed - st) / 2;
            if (check(mid)) st = mid;
            else ed = mid;
        }
        System.out.print(st);
    }
}
