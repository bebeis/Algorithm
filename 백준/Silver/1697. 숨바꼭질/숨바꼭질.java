import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {

    static int n;
    static int k;
    static int[] d = new int[100002];
    static IntUnaryOperator[] funcs = {
            (int x) -> x - 1, 
            (int x) -> x + 1,
            (int x) -> x * 2
        };
    
    public static void main(String[] args) throws IOException {
        String[] parts = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        k = Integer.parseInt(parts[1]);
        Arrays.fill(d, 0, 100001, -1);

        System.out.print(solve());
    }

    private static int solve() {
        if (n == k) return 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        d[n] = 0;

        while (!queue.isEmpty()) {
            var cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nxt = funcs[i].applyAsInt(cur);
                if (nxt < 0 || nxt > 100000) continue;
                if (d[nxt] != -1) continue;
                if (nxt == k) return d[cur] + 1;
                queue.offer(nxt);
                d[nxt] = d[cur] + 1;
            }
        }

        return -1;
    }
}
