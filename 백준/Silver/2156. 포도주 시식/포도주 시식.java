import java.io.*;
import java.util.*;

/**
 * 선택한 포도주는 모두 마시고 그 자리에 두기
 * 연속으로 위치한 포도주 3잔을 모두 마실 수 없음
 * 최대로 마실 수 있는 양의 포도주는?
 */

/**
 * i - 2 미포함 i - 1 포함 i 포함
 * i - 2 포함 i - 1 미포함 i 포함
 */


// d[i] = d[i - 3] + a[i - 1] + a[i]
// d[i] = d[i - 2] + a[i];
// d[i] = d[i - 1]

public class Main {

    static int[] d = new int[10006];
    static int[] a = new int[10006];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 4; i < n + 4; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        d[4] = a[4];

        for (int i = 4; i < n + 4; i++) {
            d[i] = Math.max(d[i - 1], d[i]);
            if (i >= 2) d[i] = Math.max(d[i], d[i - 2] + a[i]);
            if (i >= 3) d[i] = Math.max(d[i], d[i - 3] + a[i - 1] + a[i]);
        }
        
        System.out.print(d[n + 3]);
    }
}