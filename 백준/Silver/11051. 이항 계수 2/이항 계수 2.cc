#include <bits/stdc++.h>
using namespace std;

// 정신줄 놓고 풀어서 틀림

int n, r;
int dp[1001][1001];
// nCr = n! / r!(n-r)!
// nCr = n-1Cr-1 + n-1Cr

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> r;
    for (int i = 0; i <= n; i++) {
        // r = 0
        dp[i][0] = 1;
        for (int j = 1; j < i; j++) {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
        }
        // n = r
        dp[i][i] = 1;
    }
    cout << dp[n][r];

}