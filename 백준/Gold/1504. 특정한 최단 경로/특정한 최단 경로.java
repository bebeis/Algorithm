import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 0x3f3f3f3f;
    static int n;
    static int e;
    static int v1;
    static int v2;
    
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    public static long shortestPath(int st, int en) { // int로 반환했다가 틀림
        int[] d = new int[802];
        for (int i = 0 ; i <= n; i++) {
            d[i] = INF;
        }
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
        e = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Pair(c, b));
            adj.get(b).add(new Pair(c, a));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long result = INF;
        result = Math.min(result, shortestPath(1, v1) + shortestPath(v1, v2) + shortestPath(v2, n));
        result = Math.min(result, shortestPath(1, v2) + shortestPath(v2, v1) + shortestPath(v1, n));
        if (result >= INF) result = -1;
        System.out.print(result);
    }

    static class Pair implements Comparable<Pair> {
        int cost;
        int ed;

        public Pair(int c, int e) {
            cost = c; ed = e;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost < p.cost ? -1 : (this.cost == p.cost ? 0 : 1);
        }
    }
}