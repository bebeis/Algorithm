import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[] dist = new int[100002];
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        String[] parts = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        k = Integer.parseInt(parts[1]);
        Arrays.fill(dist, 0, 100002, -1);

        dist[n] = 0;
        queue.offer(n);

        while (!queue.isEmpty()) {
            var cur = queue.poll();

            // 순간이동
            int nxt = 2 * cur;
            updateAndOffer(nxt, cur, 0);
            nxt = cur + 1;
            updateAndOffer(nxt, cur, 1);
            nxt = cur - 1;
            updateAndOffer(nxt, cur, 1);
        }
        System.out.print(dist[k]);
    }

    public static void updateAndOffer(int nxt, int cur, int addDist) {
        if (nxt < 0 || nxt > 100000) return;
        if (dist[nxt] == -1 || dist[nxt] > dist[cur] + addDist) {
            dist[nxt] = dist[cur] + addDist;
            queue.offer(nxt);
        }
    }
}
