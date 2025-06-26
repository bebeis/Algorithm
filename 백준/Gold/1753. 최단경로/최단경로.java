import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int v;
    static int e;
    static int k;
    static List<ArrayList<Pair>> adj = new ArrayList<>();
    static int[] d = new int[20005];
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
            d[i] = INF;
        }
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Pair(c, b));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        d[k] = 0;
        pq.offer(new Pair(d[k], k));

        while (!pq.isEmpty()) {
            var last = pq.poll();
            if (d[last.end] != last.cost) continue;

            for (var nxt : adj.get(last.end)) {
                if (d[nxt.end] > last.cost + nxt.cost) {
                    d[nxt.end] = last.cost + nxt.cost;
                    pq.offer(new Pair(d[nxt.end], nxt.end));
                }
            }
        }

        String result = IntStream.rangeClosed(1, v)
                .mapToObj(i -> (d[i] == INF ? "INF" : String.valueOf(d[i])))
                .collect(Collectors.joining("\n"));
        System.out.print(result);
    }

    static class Pair {
        int cost;
        int end;
        public Pair(int aa, int bb) {
            cost = aa;
            end = bb;
        }
    }
}
