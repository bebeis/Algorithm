import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    
    static int n, k;
    static int[] dist = new int[100002];
    static List<Function<Integer, Integer>> functions = List.of(x -> x - 1, x -> x + 1, x -> 2 * x);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        k = Integer.parseInt(strings[1]);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == k) {
                System.out.print(dist[cur]);
                return;
            }

            for (var function : functions) {
                int next = function.apply(cur);
                if (next < 0 || next > 100000) continue;
                if (dist[next] != 0) continue;
                dist[next] = dist[cur] + 1;
                queue.offer(next);
            }
        }
    }
}
