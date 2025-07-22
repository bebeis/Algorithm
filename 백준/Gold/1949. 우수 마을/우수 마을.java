import java.io.*;
import java.util.*;

// '우수 마을'로 선정된 마을 주민 수의 총 합을 최대로 해야 한다.
// 만일 두 마을이 인접해 있으면 두 마을을 모두 '우수 마을'로 선정할 수는 없다. == 우수 마을끼리 인접 불가
// '우수 마을'로 선정되지 못한 마을은 적어도 하나의 '우수 마을'과는 인접해 있어야 한다.

// 최대 O(N^2)이나, O(N)으로 푸는게 베스트

// 1 - 2 - 3 - 4 - 5
//     6
//     7

/**
 * x에서 시작
 * d[x] -> x가 우수한 경우
 * e[x] -> x가 우수하지 않은 경우
 * - e[x]이 우수X이고, 인접한 모든 곳이 우수 or m곳 or ... 1곳 인 경우에 주민의 합
 * - d[x]가 우수 마을이고, 인접한 마을이 모두 우수하지 않은 경우에 주민의 합
 * 이미 한 번 구한 계산을 또 할 필요는 없음. 메모이제이션 쓰면 O(N)?
 * i : 1 ~ n; 
 */

public class Main {

    static int[] population = new int[10002];
    static List<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] d = new int[10002];
    static int[] e = new int[10002];

    public static void dp(int cur, int parent) {
        // 현재 마을이 우수 마을인 경우
        d[cur] = population[cur];
        for (int nxt : adj.get(cur)) {
            if (nxt == parent) continue;
            dp(nxt, cur);
            d[cur] += e[nxt];
            e[cur] += Math.max(d[nxt], e[nxt]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dp(1, 0);
        System.out.print(Math.max(d[1], e[1]));
    }
}