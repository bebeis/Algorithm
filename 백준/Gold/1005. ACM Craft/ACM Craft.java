import java.io.*;
import java.util.*;

/**
 * 건물을 짓는데 선후 관계가 존재 -> 위상 정렬의 smell
 * 일반적인 위상정렬 문제는, 가능한 경로의 수가 1가지로 정해져있지 않고 여러가지임
 * 이 중에서, 최소 시간이 소요되도록 하는 경로를 고르는 것.
 * x를 칠하기 위해서는, x의 선행 노드가 모두 완료되어야 함.
 * d[x] = Math.max(d[y], d[z]) + delay[x];
 */

public class Main {

    static int n;
    static int[] delay;
    static int[] d;
    static List<ArrayList<Integer>> adj;

    public static int dp(int cur) {
        if (d[cur] != -1) return d[cur];
        
        d[cur] = delay[cur];
        int max = 0;
        for (int nxt : adj.get(cur)) {
            max = Math.max(max, dp(nxt));
        }
        d[cur] += max;
        return d[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            delay = new int[n + 1];
            d = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
                d[i] = -1;
            }

            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj.get(v).add(u);
            }

            int w = Integer.parseInt(br.readLine());
            sb.append(dp(w)).append('\n');
        }
        System.out.print(sb);
    }
}