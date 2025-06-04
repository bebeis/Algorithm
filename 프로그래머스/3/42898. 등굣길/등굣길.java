class Solution {
    static int[][] dp = new int[102][102];
    static boolean[][] waters = new boolean[102][102];

    public int solution(int m, int n, int[][] puddles) {

        for (int[] puddle : puddles) {
            waters[puddle[1] - 1][puddle[0] - 1] = true;
        }
        
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (waters[i][0]) break;
            dp[i][0] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            if (waters[0][i]) break;
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (waters[i][j]) continue;
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        return dp[n - 1][m - 1];
    }
}