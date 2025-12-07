import java.io.*;
import java.util.*;

/**
 * 문제: 주어진 숫자를 몇 개 가지고 있는지 구하기
 * 조건: n <= 500,000, m <= 500,000
 * 원소 하나당 O(logn)으로 처리해야함 -> 정렬된 상태에서 검색 (트리, 이분 탐색)
 */

public class Main {

    static int n;
    static int[] arr = new int[500002];

    static int m;

    public static int upperBound(int target) {
        int lo = -1;
        int hi = n;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= target) lo = mid;
            else hi = mid;
        }

        return hi;
    }

    // 1 2 3 4 5 6
    // target = 7

    public static int lowerBound(int target) {
        int lo = -1;
        int hi = n;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < target) lo = mid;
            else hi = mid;
        }

        return hi;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.parallelSort(arr, 0, n);

        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(target) - lowerBound(target)).append(' ');
        }

        System.out.print(sb);
    }
}
