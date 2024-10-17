import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int start = 0;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                start = i;
                continue;
            }
            adj.get(parent).add(i);
        }

        int eraseNode = Integer.parseInt(br.readLine());

        Deque<Integer> stk = new ArrayDeque<>();
        if (start != eraseNode) stk.addLast(start);

        while (!stk.isEmpty()) {
            int cur = stk.pollLast();
            if (adj.get(cur).isEmpty()) {
                cnt++;
                continue;
            }
            boolean leaf = true;
            for (int nxt : adj.get(cur)) {
                if (eraseNode == nxt) continue;
                stk.addLast(nxt);
                if (leaf) {
                    leaf = false;
                }
            }
            if (leaf) cnt++;
        }

        System.out.println(cnt);
    }
}
