import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> freq = new HashMap<>(N * 2);
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int q = Integer.parseInt(st.nextToken());
            sb.append(freq.getOrDefault(q, 0))
              .append(' ');
        }

        System.out.print(sb);
    }
}
