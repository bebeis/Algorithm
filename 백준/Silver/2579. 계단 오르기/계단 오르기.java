import java.io.*;
import java.util.*;

/**
 * 규칙:
 *   한 번에 1 or 2계단 
 *   연속된 세계의 계단 밟기 불가능
 *   도착 계단은 반드시 밟아야 함
 */

/**
 * 문제: 마지막 계단에 도달하는 여러 방법 중, 최대 점수를 얻을 수 있는 케이스
 *   k번째에 도달하는 점수: 
 *     d[k - 2] + s[k]; // 2
 *     d[k - 3] + s[k - 1] + s[k] // 2 1
 */

public class Main {

    static int[] s = new int[302];
    static int[] d = new int[302];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(result());
    }

    public static int result() {
        d[1] = s[1];
        d[2] = s[1] + s[2];
        d[3] = Math.max(s[1] + s[3], s[2] + s[3]);
        
        for (int k = 4; k <= n; k++) {
            d[k] = Math.max(d[k - 2] + s[k], d[k - 3] + s[k - 1] + s[k]);
        }

        return d[n];
    }
}
