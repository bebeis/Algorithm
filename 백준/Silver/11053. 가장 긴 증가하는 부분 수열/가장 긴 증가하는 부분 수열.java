import java.io.*;
import java.util.*;

/**
 * 구하고자 하는 것 : 증가수열의 최대 길이
 * 테이블에 기록할 수 있는 방법 후보
 * 방법 1. key: I번째 포함 value : 길이 -- 11055에서 O(n^2)으로 풀었던 풀이와 동일
 * 방법 2. key: I번째 까지 value : 최대 길이
 * 방법 3. key: 길이      value : 마지막 원소가 위치하는 곳
 */

public class Main {

    static int n;
    static int[] a = new int[1002];
    static int[] d = new int[1002];
    
    public static void main(String[] arghs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) d[i] = Math.max(d[i], d[j]);
            }
            d[i] += 1;
        }

        System.out.print(Arrays.stream(d, 0, n).max().getAsInt());
    }
}