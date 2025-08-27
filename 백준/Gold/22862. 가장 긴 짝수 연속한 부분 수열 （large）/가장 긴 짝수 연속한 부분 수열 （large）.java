import java.io.*;
import java.util.*;


/**
 * k번 삭제 가능하다 -> 최대 k번 홀수를 허용한다.
 * 
 */

/**
 * 1 3 10 12 4 7 8
 * 7 1
 */
public class Main {

    static int n;
    static int k;
    static int[] s = new int[1000002];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; int end = 0;
        int cnt = (s[0] % 2 == 0 ? 0 : 1);
        while (start < n && end < n) {
            if (cnt > k) {
                if (s[end] % 2 != 0) cnt--;
                end++;
                continue;
            }

            result = Math.max(result, start - end - cnt + 1);
            start++;
            if (s[start] % 2 != 0) cnt++;
        }

        System.out.print(result);

    }
}