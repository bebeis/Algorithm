import java.io.*;
import java.util.*;

public class Main {

    static int p[] = new int[1002];
    static int n;
    static List<Edge> edges = new ArrayList<>();
    
    public static int find(int x) {
        if (p[x] < 0) return x;
        return p[x] = find(p[x]);
    }

    public static boolean isDiffGroup(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) return false;
        if (p[u] == p[v]) p[u]--;
        if (p[u] < p[v]) p[v] = u;
        else p[v] = u;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) p[i] = -1;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i >= j) continue;
                edges.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(edges);

        long ans = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (!isDiffGroup(edge.u, edge.v)) continue;
            ans += edge.cost;
            cnt++;

            if (cnt == n - 1) break;
        }

        System.out.print(ans);
    }

    static class Edge implements Comparable<Edge> {
        int u, v, cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost < e.cost ? -1 : (this.cost == e.cost ? 0 : 1);
        }
    }
}
