import java.util.*;

class Solution {
    
    int[] p = new int[101];
    
    public int find(int x) {
        if (p[x] < 0) return x;
        return p[x] = find(p[x]);
    }
    
    public boolean uni(int u, int v) {
        u = find(u);
        v = find(v);
        
        if (u == v) return false;
        p[u] = v;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.fill(p, -1);
        Arrays.sort(costs, (int[] x, int[] y) -> x[2] - y[2]);
        int answer = 0;
        int cnt = 0;
        for (int[] cost : costs) {
            if (!uni(cost[0], cost[1])) continue;
            answer += cost[2];
            cnt++;
            if (cnt == n - 1) break;
        }
        return answer;
    }
}