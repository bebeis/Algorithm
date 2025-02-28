import java.io.*;
import java.util.*;
// 출력 형식 문제 이해를 잘못해서 틀림...

public class Main {

    static int n;
    static int m;
    static List<Integer> list[];
    static boolean visited[];
    static boolean flag;

    public static void dfs(int before, int cur) {
        visited[cur] = true;

        for (int nxt: list[cur]) {
            if (nxt == before) continue;
            if (visited[nxt]) {
                flag = false;
                return;
            }
            dfs(cur, nxt);      
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        int no = 0;
        while (true) {
            no++;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            list = new List[n + 1];
            visited = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                list[i] = new ArrayList<>();
                visited[i] = false;
            }
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list[u].add(v);
                list[v].add(u);
            }

            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                if (visited[i] == true) continue;
                flag = true;
                dfs(0, i);
                if (flag) cnt++;
            }

            System.out.print("Case " + no + ": ");

            if (cnt == 0) {
                System.out.println("No trees.");
            } else if (cnt == 1) {
                System.out.println("There is one tree.");
            } else {
                System.out.println("A forest of " + cnt + " trees.");
            }
        }
    }
}

