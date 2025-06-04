import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (int[] c1, int[] c2) -> {
            if (c1[1] != c2[1]) return c1[1] - c2[1];
            else return c1[0] - c2[0];
        });
        int cnt = 1;
        int lastPosition = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= lastPosition) continue;
            lastPosition = routes[i][1];
            cnt++;
        }
        return cnt;
    }
}