import java.io.*;
import java.util.*;

// 시간 초과 이유: 테케마다 계산을 해버림. 테케에 공통적으로 중복되는 구조가 있으므로 쿼리 전에 모두 계산을 해둔다.

public class Main {

    static int n, r, q;
    static List<Integer> adj[];
    static int parent[];
    static int siz[];

    public static void dfs(int before, int cur) {
        parent[cur] = before;

        for (int nxt : adj[cur]) {
            if (nxt == before) continue;
            dfs(cur, nxt);
        }
    }

    public static void findSubSize(int cur) {
        siz[cur] = 1;
        for (int nxt : adj[cur]) {
            if (nxt == parent[cur]) continue;
            findSubSize(nxt);
            siz[cur] += siz[nxt];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        adj = new List[n + 1];
        parent = new int[n + 1];
        siz = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(-1, r);
        findSubSize(r);

        while (q-- > 0) {
            int start = Integer.parseInt(br.readLine());
            System.out.println(siz[start]);
        }
    }
}