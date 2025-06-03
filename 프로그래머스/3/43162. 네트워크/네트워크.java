class Solution {
    /**
      * 인접행렬과 컴퓨터 개수로부터,
      * 네트워크 개수 return
      */
    
    static boolean[] visited = new boolean[202];
    
    public static void dfs(int cur, int n, int[][] computers) {
        visited[cur] = true;
        for (int nxt = 0; nxt < n; nxt++) {
            if (nxt == cur || computers[cur][nxt] == 0 || visited[nxt]) continue;
            dfs(nxt, n, computers);
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i, n, computers);
            answer++;
        }
        return answer;
    }
}