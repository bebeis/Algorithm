import java.util.*;
class Solution {
    
    public int[] dist;
    public List<ArrayList<Integer>> adj = new ArrayList<>();

    public int solution(int n, int[][] edge) {
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pos : edge) {
            adj.get(pos[0]).add(pos[1]);
            adj.get(pos[1]).add(pos[0]);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int nxt : adj.get(cur)) {
                if (dist[nxt] != 0) continue;
                dist[nxt] = dist[cur] + 1;
                queue.offer(nxt);
            }
        }
        
        int cnt = 0;
        int max = -1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > max) {
                max = dist[i];
                cnt = 1;
            } else if (dist[i] == max) {
                cnt++;
            }
        }
        return cnt;
    }
}