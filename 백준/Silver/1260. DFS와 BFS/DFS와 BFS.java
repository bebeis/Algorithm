import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int v;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited = new boolean[1002];
    static List<ArrayList<Integer>> adj = new ArrayList<>();

    public static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(' ');

        for (int nxt : adj.get(cur)) {
            if (visited[nxt]) continue;
            dfs(nxt);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            var cur = queue.poll();
            sb.append(cur).append(' ');

            for (int nxt : adj.get(cur)) {
                if (visited[nxt]) continue;
                queue.offer(nxt);
                visited[nxt] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        v = Integer.parseInt(parts[2]);

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while (m-- > 0) {
            parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adj.get(i));
        }

        dfs(v);
        sb.append('\n');
        Arrays.fill(visited, 1, n + 1, false);
        bfs();
        
        System.out.print(sb);
    }
}