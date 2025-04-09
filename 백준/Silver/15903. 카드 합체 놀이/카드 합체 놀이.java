import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        while (m-- > 0) {
            long m1 = pq.poll();
            long m2 = pq.poll();
            pq.add(m1 + m2);
            pq.add(m1 + m2);
        }

        long sum = 0;

        for (Long x : pq) {
            sum += x;
        }

        System.out.print(sum);
    }
}