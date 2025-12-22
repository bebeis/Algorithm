import java.io.*;
import java.util.*;

/**
 * 인싸일 수록 점수가 낮음. 가장 낮은 사람이 회장
 * 회장의 점수와 회장이 될 수 있는 모든 사람?
 * 문제: 최소 거리로 모든 쌍과 연결되어 있는 노드들과 그 거리 구하기 
 */

class Main {

    static List<List<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (u == -1 && v == -1) break;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<Integer> candicates = new ArrayList<>();
        int min = 52;

        for (int i = 1; i <= n; i++) {
            int[] d = new int[n + 1];
            Arrays.fill(d, 0, n + 1, -1);

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            d[i] = 0;
            while (!queue.isEmpty()) {
                var cur = queue.poll();

                for (int nxt : adj.get(cur)) {
                    if (d[nxt] != -1) continue;
                    d[nxt] = d[cur] + 1;
                    queue.offer(nxt);
                }
            }

            int localMax = Arrays.stream(d).max().getAsInt();
            if (min > localMax) {
                min = localMax;
                candicates.clear();
                candicates.add(i);
            } else if (min == localMax) {
                candicates.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(' ').append(candicates.size()).append('\n');
        
        candicates.forEach(x -> sb.append(x).append(' '));
        System.out.print(sb);
    }
}