import java.io.*;
import java.util.*;

/**
 * 문제: 카드 묶음을 합치는데 비교 횟수 최소화
 * - 가장 작은 묶음 2개를 골라서 합치면 최소
 * - 탐색은 안하지만, 최소값은 바로 뽑을 수 있어야 함 -> 최소 힙
 */

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        while (n-- > 0) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        while (pq.size() > 1) {
            long d1 = pq.poll();
            long d2 = pq.poll();
            sum += d1 + d2;
            pq.offer(d1 + d2);
        }

        System.out.print(sum);
    }
}