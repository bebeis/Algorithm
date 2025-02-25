import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited = new boolean[502];
    static int[] dist = new int[502];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer> adj[] = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        Deque<Integer> Q = new ArrayDeque<>();
        Q.offer(1);
        visited[1] = true;
        dist[1] = 0;
        int cnt = 0;

        while (!Q.isEmpty()) {
            int cur = Q.poll();
            if (dist[cur] == 2) continue;

            for (int nxt : adj[cur]) {
                if (visited[nxt] == true) continue;
                visited[nxt] = true;
                Q.offer(nxt);
                dist[nxt] = dist[cur] + 1;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}