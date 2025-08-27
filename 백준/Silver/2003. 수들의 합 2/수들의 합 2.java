import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] a = new int[10002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int s = 0, e = 0;
        int sum = a[0];
        while (s < n && e < n) {
            if (sum == m) {
                cnt++;
            }
            if (sum > m) {
                sum -= a[e];
                e++;
            } else {
                s++;
                if (s < n) sum += a[s];
            }
        }
        System.out.print(cnt);
    }
}