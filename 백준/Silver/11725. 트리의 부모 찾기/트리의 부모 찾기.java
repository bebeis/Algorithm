import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static List<Integer> parent;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        parent = new ArrayList<>(Collections.nCopies(n + 1, 0));
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            graph.get(cur).stream()
                .filter(nxt -> !visited[nxt])
                .forEach(nxt -> {
                    parent.set(nxt, cur);
                    visited[nxt] = true;
                    queue.offer(nxt);
                });
        }

        StringBuilder sb = new StringBuilder();
        parent.stream()
            .skip(2)
            .forEach(p -> sb.append(p).append('\n'));
        
        System.out.print(sb);
    }
}
