import java.io.*;
import java.util.*;

// 탈출 조건이 n - 1 -> n - 2로 바꾸는 것까지는 맞음.
// n - 2로 바꾸면, 노드가 2개인 경우 반띵 나누면 경로가 없어도됨.
// 먼저 ans를 더하고 if n - 2 == 0을 체크하기 때문에 n = 2에서 엣지 케이스 통과가 안됨
// 엣지 케이스 놓쳐서 틀림

public class Main {

    static int n, m;
    static int p[] = new int[100002];
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) p[i] = -1;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);
        int ans = 0, cnt = 0;

        for (Edge edge : edges) {
            if (!isDiffGroup(edge.u, edge.v)) continue;
            ans += edge.cost;
            cnt++;
            if (cnt == n - 2) break;
        }

        if (n == 2) ans = 0;

        System.out.print(ans);
    }

    static class Edge implements Comparable<Edge> {
        int u, v, cost;
        public Edge(int a, int b, int c) {
            u = a;
            v = b;
            cost = c;
        }

        @Override
        public int compareTo(Edge e) {
            return cost < e.cost ? -1 : (cost == e.cost ? 0 : 1);
        }
    }
}