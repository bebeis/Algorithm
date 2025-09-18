import java.io.*;
import java.util.*;

/**
 * 면접자들은 서로 다른 N개의 도시에 거주
 * N개 도시 중 K개의 도시에 면접장 배치
 * 도시끼리는 단방향, 도로가 두 도시 사이에 여러개 있을 수 있음
 */

/**
 * 어떻게든 도시에서 면접장까지 경로가 있다.
 * 면접자들은 가장 가까운 면접장으로 찾아간다. -> 최단 경로 문제
 */

/**
 * 가장 먼 곳에서 온 면접자는 누구인지, 그리고 그 거리는?
 */

/**
 * sol)
 * 다익스트라를 돌리면, 하나의 거주지에서 각 노드까지 걸리는지 알 수 있음
 * 거주지 1개당 시간 복잡도: O(ElogV) : O(500,000 * 6) = O(3,000,000)
 * 거주지는 N개 -> O(N^2logV) -> 시간 초과
 * 무조건 한번에 다 탐색해야 함.
 * 물대기 문제에서, 하나의 가짜 노드를 두고 풀었다.
 * 여기서도 마찬가지, 하나의 가짜노드를 두고 생각해보자.
 * 각 도시에서 면접장까지의 거리 중, 그 거리가 가장 먼 도시에서 오는 면접자에게 교통비를 준다
 * 즉, 면접장이 어디인지는 상관이 없는거다.
 * 가짜 노드를 면접장이랑 연결하고, 거기서 가장 먼 노드를 찾는다.
 */

public class Main {
    
    static int n, m, k;
    static long[] d = new long[100002];
    static List<List<Pair>> adj = new ArrayList<>();
    final static long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n + 1; i++) {
            adj.add(new ArrayList<>());
            d[i] = INF;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(v).add(new Pair(w, u));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            adj.get(n + 1).add(new Pair(0, Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Long.compare(p1.cost, p2.cost));
        d[n + 1] = 0;
        pq.offer(new Pair(d[n + 1], n + 1));

        while (!pq.isEmpty()) {
            Pair last = pq.poll();
            if (last.cost != d[last.end]) continue;

            for (Pair nxt : adj.get(last.end)) {
                if (d[nxt.end] > last.cost + nxt.cost) {
                    d[nxt.end] = last.cost + nxt.cost;
                    pq.offer(new Pair(d[nxt.end], nxt.end));
                }
            }
        }

        int maxPlace = 0;
        long maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) continue;
            if (d[i] > maxDist) {
                maxDist = d[i];
                maxPlace = i;
            }
        }

        System.out.print(maxPlace + "\n" + maxDist);
    }

    static class Pair {
        long cost;
        int end;
        public Pair(long cost, int end) {
            this.cost = cost;
            this.end = end;
        }
    }
}