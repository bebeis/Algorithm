import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int deg[] = new int[1002];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            List<Integer> order = new ArrayList<>();
            while (k-- > 0) {
                order.add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 1; i < order.size(); i++) {
                adj.get(order.get(i - 1)).add(order.get(i));
                deg[order.get(i)]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);

            for (int nxt : adj.get(cur)) {
                deg[nxt]--;
                if (deg[nxt] == 0) {
                    queue.offer(nxt);
                }
            }
        }
        if (result.size() != n) {
            sb.append(0);
        } else {
            for (int x : result) {
                sb.append(x).append('\n');
            }
        }
        System.out.print(sb);
    }
}
