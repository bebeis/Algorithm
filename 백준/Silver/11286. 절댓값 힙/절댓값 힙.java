import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            } else {
                return Math.abs(a) - Math.abs(b);
            }
        });
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int cur = Integer.parseInt(br.readLine());
            if (cur == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else {
                pq.offer(cur);
            }
        }
        System.out.print(sb);
    }
}
