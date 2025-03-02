import java.io.*;
import java.util.*;

// LCA 알고리즘
public class Main {
    static int N, M, LOG;
    static ArrayList<Edge>[] graph;
    static int[][] parent;
    static int[] depth, dist;

    static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void dfs(int cur, int par) {
        parent[cur][0] = par;
        for (Edge e : graph[cur]) {
            if (e.to == par) continue;
            depth[e.to] = depth[cur] + 1;
            dist[e.to] = dist[cur] + e.weight;
            dfs(e.to, cur);
        }
    }

    // 두 노드의 최소 공통 조상(LCA)을 찾는 함수 (binary lifting 이용)
    static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v])
                u = parent[u][i];
        }
        if (u == v) return u;
        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }
        return parent[u][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        LOG = 0;
        while ((1 << LOG) <= N) LOG++;
        parent = new int[N + 1][LOG];
        depth = new int[N + 1];
        dist = new int[N + 1];

        dfs(1, 0);

        for (int k = 1; k < LOG; k++) {
            for (int i = 1; i <= N; i++) {
                parent[i][k] = parent[parent[i][k - 1]][k - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int lca = lca(u, v);
            int answer = dist[u] + dist[v] - 2 * dist[lca];
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
