import java.io.*;
import java.util.*;

/**
 * O(nlogn) 이하로 풀이!
 */

public class Main {

    static int[] a = new int[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a, 0, n);
        
        int result = Integer.MAX_VALUE;
        int st = 0, ed = 0;
        while (st <= n && ed <= n) {
            int diff = a[st] - a[ed];
            if (diff >= m) {
                result = Math.min(result, diff);
                ed++;
            } else {
                st++;
            }
        }
        System.out.print(result);
    }
}