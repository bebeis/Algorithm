import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    // 인접리스트에 이웃 노드만 저장하고, 간선 가중치는 전역 dist[][]에 저장 (직접 연결된 경우)
    static int dist[][] = new int[1002][1002];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static int bfs(int start, int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int[] d = new int[n + 1];
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == target) return d[cur];
            for (int nxt : adj.get(cur)) {
                if (visited[nxt]) continue;
                d[nxt] = d[cur] + dist[cur][nxt];
                visited[nxt] = true;
                queue.offer(nxt);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 양방향 그래프
            adj.get(u).add(v);
            adj.get(v).add(u);
            dist[u][v] = w;
            dist[v][u] = w;
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int ans = bfs(u, v);
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
