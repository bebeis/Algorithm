import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static List<String> names = new ArrayList<>();
    static TreeSet<String> ancestors = new TreeSet<>();
    static int deg[] = new int[1002];
    static ArrayList<ArrayList<Integer>> pgraph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> cgraph = new ArrayList<>();
    static Map<String, TreeSet<String>> childs = new TreeMap<>();

    public static int findIndexByName(String name) {
        for (int i = 0; i < n; i++) {
            if (names.get(i).equals(name)) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            pgraph.add(new ArrayList<>());
            cgraph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) names.add(st.nextToken());
        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = findIndexByName(st.nextToken());
            int v = findIndexByName(st.nextToken());
            pgraph.get(u).add(v);
            cgraph.get(v).add(u);
            deg[u]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) queue.offer(i);
            if (pgraph.get(i).size() == 0) ancestors.add(names.get(i));
        }
        sb.append(ancestors.size()).append('\n');
        for (String name : ancestors) {
            sb.append(name).append(' ');
        }
        sb.append('\n');

        for (String name : names) {
            childs.put(name, new TreeSet<>());
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int nxt : cgraph.get(cur)) {
                deg[nxt]--;
                if (deg[nxt] == 0) {
                    childs.get(names.get(cur)).add(names.get(nxt));
                    queue.offer(nxt);
                }
            }
        }

        for (String name : childs.keySet()) {
            TreeSet<String> list = childs.get(name);
            sb.append(name).append(' ').append(list.size()).append(' ');
            for (String child : list) sb.append(child).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
