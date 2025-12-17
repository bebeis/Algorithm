import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int m;
    static boolean[] visited = new boolean[1002];
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            bfs(i);
            cnt++;
        }

        System.out.print(cnt);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            var cur = queue.poll();

            for (int nxt : graph.get(cur)) {
                if (visited[nxt]) continue;
                queue.offer(nxt);
                visited[nxt] = true;
            }
        }
    }
}