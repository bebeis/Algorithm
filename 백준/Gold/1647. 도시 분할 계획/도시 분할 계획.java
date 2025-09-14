import java.io.*;
import java.util.*;

/**
 * n개의 노드, m개의 엣지 (양방향)
 * 엣지를 유지하는 유지비 존재.
 * 노드들은 어떻게든 연결되어 있음
 */

/**
 * 목표: 두 개의 연결 요소로 분리하고, 엣지 유지비를 최소로 하게 만들자.
 * - 분리된 두 마을 사이의 엣지 제거
 * - 마을 내 불필요한 엣지 제거
 */

/**
 * sol) 주어진 엣지 정보를 바탕으로 MST를 만들고, 가중치가 가장 큰 엣지를 제거
 */
public class Main {

    static int n;
    static int m;
    static int[] p = new int[100002];

    public static int find(int x) {
        if (p[x] < 0) return x;
        return p[x] = find(p[x]);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;
        p[x] = y;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Arrays.fill(p, 1, n + 1, -1);

        List<Edge> edges = new ArrayList<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges, (e1, e2) -> e1.w - e2.w);

        int cnt = 0;
        int result = 0;
        for (Edge edge : edges) {
            if (union(edge.s, edge.e)) {
                result += edge.w;
                cnt++;
            }

            if (cnt == n - 1) {
                result -= edge.w;
                break;
            }
        }

        System.out.print(result);
    }

    static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}