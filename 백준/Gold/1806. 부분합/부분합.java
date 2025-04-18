import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int s;
    static int arr[] = new int[100002];
    static int sum[] = new int[100002];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[1] = arr[1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int start = 1, end = 1;
        while (start <= n && end <= n) {
            int temp;
            if (start == end) temp = arr[start];
            else temp = sum[start] - sum[end - 1];
            

            if (temp >= s) {
                answer = Math.min(answer, start - end + 1);
                if (start > end) end++;
                else start++;
                continue;
            }

            start++;
        }

        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.print(answer);
    }
}