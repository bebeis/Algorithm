import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static List<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited = new boolean[1002];

    public static void dfs(int cur) {
        visited[cur] = true;

        for (int nxt : adj.get(cur)) {
            if (visited[nxt]) continue;
            dfs(nxt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            dfs(i);
            cnt++;
        }
        System.out.print(cnt);
    }
}
