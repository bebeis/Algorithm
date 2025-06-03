import java.util.*;
class Solution {
    
    public int solution(int[][] triangle) {
        int[][] dp = new int[502][502]; // i, j 를 거쳤을 때, 최댓값
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j < triangle[i].length) // 오른쪽 위
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + triangle[i][j]);
                if (j - 1 >= 0) // 왼쪽 위
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + triangle[i][j]);
            }
        }
        return Arrays.stream(dp[triangle.length - 1], 0, triangle.length)
            .max().getAsInt();
    }
}