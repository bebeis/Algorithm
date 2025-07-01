import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    final static int INF = 0x3f3f3f3f;

    static int n;
    static int m;
    static int st;
    static int ed;
    static int[] dist = new int[1002];
    static int[] pre = new int[1002];
    static List<ArrayList<Pair>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            dist[i] = INF;
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new Pair(w, v));
        }
        String[] parts = br.readLine().split(" ");
        st = Integer.parseInt(parts[0]);
        ed = Integer.parseInt(parts[1]);
        dist[st] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        pq.offer(new Pair(dist[st], st));

        while (!pq.isEmpty()) {
            Pair last = pq.poll();

            if (dist[last.dst] != last.cost) continue;
            for (Pair nxt : adj.get(last.dst)) {
                if (last.cost + nxt.cost >= dist[nxt.dst]) continue;
                dist[nxt.dst] = last.cost + nxt.cost;
                pq.add(new Pair(dist[nxt.dst], nxt.dst));
                pre[nxt.dst] = last.dst;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[ed]).append("\n");

        List<Integer> path = new ArrayList<>();
        while (ed != st) {
            path.add(ed);
            ed = pre[ed];
        }
        path.add(st);

        sb.append(path.size()).append('\n');
        IntStream.range(0, path.size())
                .map(i -> path.size() - 1 - i)
                .forEach(i -> sb.append(path.get(i)).append(' '));
        System.out.print(sb);
    }

    static class Pair {
        int cost;
        int dst;

        public Pair(int cost, int dst) {
            this.cost = cost;
            this.dst = dst;
        }
    }
}
