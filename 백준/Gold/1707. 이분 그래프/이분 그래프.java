import java.io.*;
import java.util.*;

/**
 * 1. 인접한 두 노드는 같은 집합에 포함되면 안 됨.
 * 2. 집합에 같은 원소끼리도 연결관계까 있으면 안됨
 * X Y
 * 
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            List<List<Integer>> adj = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int[] bs = new int[V + 1]; // X: -1, Y: 1, 미정: 0
            for (int i = 0; i <= V; i++) {
                adj.add(new ArrayList<>());
            }

            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            boolean check = false;
            for (int i = 1; i <= V; i++) {
                if (bs[i] != 0) continue;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                bs[i] = -1;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();

                    for (int nxt : adj.get(cur)) {
                        if (bs[nxt] == bs[cur]) {
                            check = true;
                            break;
                        }
                        if (bs[nxt] == 0) {
                            bs[nxt] = -1 * bs[cur];
                            queue.offer(nxt);
                        }
                    }
                    if (check) break;
                }
                if (check) break;
            }

            if (check) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.print(sb);
    }
}