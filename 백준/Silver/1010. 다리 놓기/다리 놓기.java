import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long m = Integer.parseInt(st.nextToken());
            long result = 1;

            // nCm = nC(n-m) 을 이용해 더 작은 수를 골라 계산량 줄이기
            n = Math.min(n, m - n);

            for (int j = 1; j <= n; j++, m--) {
                result *= m;
                result /= j;  // 여기서 바로 나누어 간소화
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}