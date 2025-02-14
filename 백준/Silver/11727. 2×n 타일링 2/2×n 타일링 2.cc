#include <bits/stdc++.h>
using namespace std;

int dp[1002];
int n;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n;
    dp[1] = 1;
    dp[0] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
    }
    cout << dp[n];
}