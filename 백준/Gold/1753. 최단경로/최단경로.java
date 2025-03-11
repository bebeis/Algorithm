import java.io.*;
import java.util.*;

public class Main {

    static int v, e, k;
    static int d[] = new int[20002];
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i <= v; i++) {
            d[i] = INF;
            adj.add(new ArrayList<>());
        }

        while (e-- > 0 ) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Pair(c, b));
        }

        d[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(d[k], k));
        while (!pq.isEmpty()) {
            var cur = pq.poll();
            if (d[cur.ed] != cur.cost) continue;
            for (var nxt : adj.get(cur.ed)) {
                if (d[nxt.ed] <= d[cur.ed] + nxt.cost) continue;
                d[nxt.ed] = d[cur.ed] + nxt.cost;
                pq.add(new Pair(d[nxt.ed], nxt.ed));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= v; i++) {
            if (d[i] == INF) sb.append("INF\n");
            else sb.append(d[i]).append('\n');
        }

        System.out.print(sb);
    }

    static class Pair implements Comparable<Pair> {
        int cost;
        int ed;

        public Pair(int cost, int ed) {
            this.cost = cost;
            this.ed = ed;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost < p.cost ? -1 : (this.cost == p.cost ? 0 : 1);
        }
    }
}