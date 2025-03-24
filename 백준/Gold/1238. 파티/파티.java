import java.io.*;
import java.util.*;

// ASP로 풀기엔 O(n^3) -> 초과
// 다익스트라.

public class Main {

    static final int INF = 0x3f3f3f3f;

    static int n;
    static int m;
    static int x;
    
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    public static int shortestPath(int st, int en) {
        int d[] = new int[n + 1];
        for (int i = 0; i <= n; i++) d[i] = INF;
        d[st] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(d[st], st));

        while (!pq.isEmpty()) {
            var cur = pq.poll();
            if (cur.cost != d[cur.ed]) continue;

            for (var nxt : adj.get(cur.ed)) {
                if (d[nxt.ed] <= d[cur.ed] + nxt.cost) continue;
                d[nxt.ed] = d[cur.ed] + nxt.cost;
                pq.add(new Pair(d[nxt.ed], nxt.ed));
            }
        }

        return d[en];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Pair(c, v));
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, shortestPath(i, x) + shortestPath(x, i));
        }

        System.out.print(ans);
    }

    static class Pair implements Comparable<Pair> {
        int cost;
        int ed;

        public Pair(int c, int e) {
            cost = c;
            ed = e;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost < p.cost ? -1 : (this.cost == p.cost ? 0 : 1);
        }
    }
}
