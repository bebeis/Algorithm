import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean[] visited = new boolean[101];
        int[] d = new int[101];
        List<List<Integer>> adj = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int input_size = Integer.parseInt(br.readLine());

        for (int i = 0; i < input_size; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        d[u] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == v) {
                System.out.println(d[v]);
                return;
            }
            for (int nxt : adj.get(cur)) {
                if (visited[nxt]) continue;
                visited[nxt] = true;
                d[nxt] = d[cur] + 1;
                queue.add(nxt);
            }
        }
        System.out.println(-1);
    }
}
