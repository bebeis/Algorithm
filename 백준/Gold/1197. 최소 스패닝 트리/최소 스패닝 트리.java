import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static int m;
    static int[] p = new int[10001];

    public static int find(int x) {
        if (p[x] < 0) return x;
        else return p[x] = find(p[x]);
    }

    public static boolean uni(int x, int y) {
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
        for (int i = 1; i <= n; i++) p[i] = -1;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(u, v, w));
        }

        int totalWeight = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            var cur = pq.poll();

            if (!uni(cur.u, cur.v)) continue;
            totalWeight += cur.w;
            cnt++;
            if (cnt == n - 1) break;
        }

        System.out.print(totalWeight);

    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        public Edge(int uu, int vv, int ww) {
            u = uu;
            v = vv;
            w = ww;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
}