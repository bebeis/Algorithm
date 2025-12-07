import java.io.*;
import java.util.*;

/**
 * 문제: 주어진 숫자 리스트 내에 원하는 요소 찾기
 * 조건: n <= 100,000, m <= 100,000
 * - 하나의 원소를 찾을 때 o(logn)으로 찾아야 한다
 * - 한 번 전처리 해두고, 그 결과를 이용해야 함 -> 정렬
 */
class Main {

    static int n;
    static int[] arr = new int[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.parallelSort(arr, 0, n);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(arr, 0, n, target) < 0) sb.append("0\n");
            else sb.append("1\n");
        }
        System.out.print(sb);
    }
}