import java.io.*;
import java.util.*;

/**
 * 1 ~ N번 문제 : 난이도 오름차순
 * 먼저 푸는 것이 좋은 쌍 존재
 * 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
 * - A번 문제는 B번 문제보다 먼저 푸는 것이 좋다 -> B의 indeg++;
 * 가능하면 쉬운 문제부터 -> 우선순위 큐로 오름차순
 */

/**
 * 위상정렬처럼 풀지만, 풀 수 있는 문제가 여러가지면 쉬운 문제부터 풀어야 한다.
 */

public class Main {

    static int n;
    static int m;
    static int indeg[] = new int[32002];
    static List<List<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            indeg[b]++;
            adj.get(a).add(b);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(' ');

            for (int nxt : adj.get(cur)) {
                if (--indeg[nxt] == 0) {
                    pq.offer(nxt);
                }
            }
        }

        System.out.print(sb);
    }
}