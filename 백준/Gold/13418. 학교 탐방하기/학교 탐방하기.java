import java.io.*;
import java.util.*;

public class Main {

    static int[] p = new int[1002];
    static int n;
    static int m;
    
    static int find(int x) {
        if (p[x] < 0) return x;
        else return p[x] = find(p[x]);
    }

    static boolean uni(int x, int y) {
        x = find(x); y = find(y);
        
        if (x == y) return false;
        
        p[y] = x; 
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Arrays.fill(p, 0, n + 1, -1);

        PriorityQueue<Edge> bpq = new PriorityQueue<>((p1, p2) -> p2.w - p1.w);
        PriorityQueue<Edge> wpq = new PriorityQueue<>((p1, p2) -> p1.w - p2.w);
        for (int i = 0; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bpq.offer(new Edge(u, v, w));
            wpq.offer(new Edge(u, v, w));
        }

        int bestTotalCnt = 0;
        int bestAscCnt = 0;

        while (!bpq.isEmpty()) {
            var cur = bpq.poll();

            if (!uni(cur.u, cur.v)) continue;
            if (cur.w == 0) bestAscCnt++;
            bestTotalCnt++;
            if (bestTotalCnt == n) break;
        }

        int worstTotalCnt = 0;
        int worstAscCnt = 0;
        Arrays.fill(p, 0, n + 1, -1);

        while (!wpq.isEmpty()) {
            var cur = wpq.poll();

            if (!uni(cur.u, cur.v)) continue;
            if (cur.w == 0) worstAscCnt++;
            worstTotalCnt++;
            if (worstTotalCnt == n) break;
        }
        System.out.print(worstAscCnt * worstAscCnt - bestAscCnt * bestAscCnt);
    }

    static class Edge {
        int u;
        int v;
        int w;

        public Edge(int uu, int vv, int ww) {
            u = uu;
            v = vv;
            w = ww;
        }
    }
}