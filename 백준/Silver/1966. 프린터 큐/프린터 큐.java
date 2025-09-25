import java.util.*;
import java.io.*;

/**
 * 큐의 front에 있는 문서가 가장 중요한게 아니면 가장 뒤에 재배치
 * - 가장 중요한 문서인 경우에만 pop
 * 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지
 */

/**
 * 정렬로 해결이 불가능함. 같은 값이 여러개 있을 경우 몇 번째에 제거된다는 걸 확실히 알 수 없음
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Pair> queue = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((Integer i1, Integer i2) -> i2.compareTo(i1));

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(st.nextToken());
                queue.offer(new Pair(val, i));
                pq.offer(val);
            }

            int cnt = 0;
            while (true) {
                Pair cur = queue.poll();
                if (cur.val != pq.peek()) {
                    queue.offer(cur);
                }
                else {
                    pq.poll();
                    cnt++;
                    if (cur.nth == m) {
                        sb.append(cnt).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }

    static class Pair {
        int val;
        int nth;

        public Pair(int v, int n) {
            val = v;
            nth = n;
        }
    }
}