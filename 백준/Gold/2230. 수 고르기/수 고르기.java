import java.io.*;
import java.util.*;

/**
 * 문제: 두 수의 차이의 lowerbound 구하기
 * 입력 조건: n <= 100,000 -> O(nlogn)
 * - 브루트 포스 불가능. 즉, 모든 쌍의 차를 구하면 안 됨
 * - 순서를 유지할 필요 없음 -> 정렬
 */
public class Main {

    static int n;
    static int m;
    static int[] a = new int[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.parallelSort(a, 0, n);
        int head = 0, tail = 0;
        int result = Integer.MAX_VALUE;
        while (head < n && tail < n) {
            int diff = a[head] - a[tail];
            if (diff < m) {
                head++;
            } else {
                result = Math.min(result, diff);
                if (head == tail) head++;
                else tail++;
            }
        }

        System.out.print(result);
    }
}