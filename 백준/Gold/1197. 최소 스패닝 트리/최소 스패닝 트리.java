import java.io.*;
import java.util.*;

public class Main {

    static int v;
    static int[] p = new int[10002];

    public static int find(int x) {
        if (p[x] < 0) return x;
        return p[x] = find(p[x]);
    }

    public static boolean union(int x, int y) {
        x = find(x); y = find(y);
        if (x == y) return false;
        
        p[x] = y;
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        Arrays.fill(p, 0, v + 1, -1);

        // 0 : u, 1 : v, 2 : cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[2] - b[2]);
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{u, v, cost});
        }

        long result = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            var cur = pq.poll();
            int p = cur[0];
            int q = cur[1];
            int cost = cur[2];

            if (!union(p, q)) continue;
            
            result += cost;
            cnt++;
            if (cnt == v - 1) break;
        }

        System.out.print(result);
    }
}