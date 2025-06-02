import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] p = new int[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int nxt : adj.get(cur)) {
                if (nxt == p[cur]) continue;
                p[nxt] = cur;
                queue.offer(nxt);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(p[i]).append('\n');
        }
        System.out.print(sb);
    }
}
