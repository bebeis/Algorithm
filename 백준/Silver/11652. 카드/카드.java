import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static long arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long minValue = arr[0];
        int cnt = 1;
        int tempCnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                tempCnt++;
            } else {
                if (tempCnt > cnt) {
                    minValue = arr[i - 1];
                    cnt = tempCnt;
                }
                tempCnt = 1;
            }
        }
        if (tempCnt > cnt) {
            minValue = arr[n - 1];
        }

        System.out.print(minValue);
    }
}
