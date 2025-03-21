import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 0x3f3f3f3f;
    static int n;
    static int m;
    static int[] pre = new int[1002];
    static int[] d = new int[1002];
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            d[i] = INF;
        }
        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(s).add(new Pair(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.add(new Pair(start, d[start]));

        while (!pq.isEmpty()) {
            var cur = pq.poll();
            if (cur.cost != d[cur.ed]) continue;

            for (var nxt : adj.get(cur.ed)) {
                if (d[nxt.ed] <= d[cur.ed] + nxt.cost) continue;
                d[nxt.ed] = d[cur.ed] + nxt.cost;
                pre[nxt.ed] = cur.ed;
                pq.add(new Pair(nxt.ed, d[nxt.ed]));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d[end]).append("\n");

        List<Integer> path = new ArrayList<>();
        // 무조건 cur 변수를 빼줘야 한다. 
        // 안그러면 노드가 2개 있는 경우 목적지 자체를 누락하게 된다.
        int cur = end;
        while (cur != start) {
            path.add(cur);
            cur = pre[cur];
        }
        path.add(start);
        sb.append(path.size()).append('\n');
        Collections.reverse(path);
        for (Integer x : path) {
            sb.append(x).append(' ');
        }
        System.out.print(sb);
    }

    static class Pair implements Comparable<Pair> {
        int ed;
        int cost;

        public Pair(int n, int c) {
            ed = n;
            cost = c;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost < p.cost ? -1 : (this.cost == p.cost ? 0 : 1);
        }
    }
}