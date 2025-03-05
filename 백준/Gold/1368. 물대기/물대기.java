import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int p[] = new int[302];
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
        else p[u] = v;
        return true;
    }
        // 최소 1곳은 우물을 파야한다.
        // -> n + 1번째에 1~n 중 최소 하나는 연결되어야 한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            edges.add(new Edge(i, n + 1, Integer.parseInt(br.readLine())));
            p[i] = -1;
        }
        p[n + 1] = -1;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (i >= j) continue;
                edges.add(new Edge(i, j, temp));
            }
        }

        Collections.sort(edges);
        n++;

        int cnt = 0;
        int ans = 0;
        for (Edge edge : edges) {
            if (!isDiffGroup(edge.start, edge.end)) continue;
            ans += edge.cost;
            cnt++;
            if (cnt == n - 1) break;
        }

        System.out.println(ans);
    }

    static class Edge implements Comparable<Edge> {
        int cost;
        int start;
        int end;

        public Edge(int s, int e, int c) {
            cost = c;
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost < e.cost ? -1 : (this.cost == e.cost ? 0 : 1);
        }

    }
}
