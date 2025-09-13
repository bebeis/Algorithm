import java.io.*;
import java.util.*;

/**
 * 방법 1. 우물 직접 파기
 * 방법 2. 물 끌어오기
 * 각각의 논에서 직접 파는 비용, 끌어오는 비용이 주어짐
 * 최소 비용으로 모든 논에 물을 대자
 */

/**
 * 아이디어: 우물에서 직접 파는 것을 새로운 논에서 물을 대는 것으로 치환한다.
 * 논은 N + 1개가 되고, N + 1번 논은 우물을 직접 파는 것과 대응됨. 이 우물은 반드시 다른 우물과 연결되므로 조건 만족
 * 이렇게 되면 최소 신장 트리 문제로 치환됨
 */

public class Main {

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


    static int[] p = new int[302];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n + 1; i++) p[i] = -1;

        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int weight = Integer.parseInt(br.readLine());
            edges.add(new Edge(n + 1, i, weight));
        }

        for (int i = 1; i <= n; i++) {
            String[] weights = br.readLine().split(" ");
            for (int j = 1; j <= i - 1; j++) {
                int weight = Integer.parseInt(weights[j - 1]);
                edges.add(new Edge(i, j, weight));
            }
        }

        Collections.sort(edges, (e1, e2) -> e1.w - e2.w);
        int result = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (union(edge.s, edge.e)) {
                result += edge.w;
                cnt++;
            }

            if (cnt == n) break;
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
