import java.io.*;
import java.util.*;

/*
 * x[i] 이하에 몇 개의 원소가 있는지로 converting
 * 정렬한 다음 해당 upper_bound 위치로 구할 수 있을 듯
 */

public class Main {

    static int[] x = new int[1000002];
    static int[] sorted;
    static int[] c = new int[1000002];
    static int n;

    public static int lowerBound(int target) {
        int lo = -1, high = sorted.length;
        while (lo + 1 < high) {
            int mid = (lo + high) / 2;
            if (sorted[mid] < target) lo = mid;
            else high = mid;
        }
        return high;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        sorted = Arrays.stream(x, 0, n).sorted().distinct().toArray();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(x, 0, n)
            .map(Main::lowerBound)
            .forEach(p -> sb.append(p).append(' '));
        
        System.out.print(sb);
    }
}