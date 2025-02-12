#include <bits/stdc++.h>
using namespace std;

int n;
int dp[1002];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
    }
    cout << dp[n];
}