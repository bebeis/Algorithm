import java.io.*;
import java.util.*;

/**
 * N개의 마을, 각 1명의 학생
 * 마을 사이에는 M개의 단방향 도로, Ti 시간 소비
 * 파티 참석하려면 걸어가서 돌아가야 함(오고 가는길이 다름)
 * 가장 많은 시간 소비하는 학생?
 */

/**
 * X번 마을에서 각 마을까지 가는 최단 거리 -> 다익스트라 1번
 * 각 마을에서 X까지 가는 최단 거리 -> 다익스터라 N번  O(Elogv) = O(30 000 000)
 */
public class Main {

    static int n;
    static int m;
    static int x;
    static List<List<Pair>> adj = new ArrayList<>();
    static int[] downDist = new int[1002];
    
    final static int INF = 0x3f3f3f3f;

    public static void calculateDownDist() {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        downDist[x] = 0;
        pq.offer(new Pair(downDist[x], x));

        while (!pq.isEmpty()) {
            Pair last = pq.poll();
            if (downDist[last.end] != last.cost) continue;

            for (Pair nxt : adj.get(last.end)) {
                if (downDist[nxt.end] > last.cost + nxt.cost) {
                    downDist[nxt.end] = last.cost + nxt.cost;
                    pq.offer(new Pair(downDist[nxt.end], nxt.end));
                }
            }
        }
    }

    public static int calculateUpDist(int start) {
        int[] d = new int[n + 1];
        Arrays.fill(d, 1, n + 1, INF);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        d[start] = 0;
        pq.offer(new Pair(d[start], start));

        while (!pq.isEmpty()) {
            var last = pq.poll();
            if (d[last.end] != last.cost) continue;

            for (var nxt : adj.get(last.end)) {
                if (d[nxt.end] > last.cost + nxt.cost) {
                    d[nxt.end] = last.cost + nxt.cost;
                    pq.offer(new Pair(d[nxt.end], nxt.end));
                }
            }
        }

        return d[x];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            downDist[i] = INF;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj.get(s).add(new Pair(t, e));
        }
        calculateDownDist();

        int answer = -1;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, calculateUpDist(i) + downDist[i]);
        }

        System.out.print(answer);
    }

    static class Pair {
        int cost;
        int end;
        public Pair(int cost, int end) {
            this.cost = cost;
            this.end = end;
        }
    }
}