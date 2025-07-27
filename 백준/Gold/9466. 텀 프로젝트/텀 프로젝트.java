import java.io.*;
import java.util.*;

// 팀을 이루는 기준 -> 사이클이 형성되어야 함. 
// O(nlogn) 이하로 풀이
/**
 * x에서 출발 -> x을 포함하는 사이클 발견 (y개)
 *          -> x를 포함하지 않는 사이클 발견 (y개)
 *          -> 탐색하면서 거쳐간 사람은 다시 방문하지 않아도 결과를 암
 *          조심해야 할 케이스
 *          -> 이번 탐색에서, 과거 탐색된 곳에 방문
 * 결국에는, 모든 사람을 한 번씩만 방문하면 되므로 O(n)
 */         

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] choice = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            int[] cycle = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);

                int bp = -1;
                while (!queue.isEmpty()) {
                    var cur = queue.poll();
                    visited[cur] = true;

                    int next = choice[cur];
                    if (cycle[next] != 0) break;
                    if (visited[next]) {
                        bp = next;
                        break;
                    }
                    queue.offer(next);
                }

                if (bp != -1) {
                    cycle[bp] = bp;
                    int nxt = choice[bp];
                    while (nxt != bp) {
                        cycle[nxt] = bp;
                        nxt = choice[nxt];
                    }
                }

                bp = i;
                while (cycle[bp] == 0) {
                    cycle[bp] = -1;
                    bp = choice[bp];
                }
            }

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (cycle[i] == -1) sum++;
            }
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}