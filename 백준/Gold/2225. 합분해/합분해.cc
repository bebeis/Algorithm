#include <bits/stdc++.h>
using namespace std;

const int MOD = 1000000000;
int n, k;
int dp[201][201];
// 고를 수 있는 숫자의 범위가 1부터가 아니라 0부터임... 문제를 잘 보자

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> k;

    dp[0][0] = 1;

    for (int x = 1; x <= k; x++) {
        for (int y = 0; y <= n; y++) {
            for (int i = 0; i <= y; i++) {
                dp[x][y] = (dp[x][y] + dp[x - 1][y - i]) % MOD;
            }
        }
    }

    cout << dp[k][n];
}
