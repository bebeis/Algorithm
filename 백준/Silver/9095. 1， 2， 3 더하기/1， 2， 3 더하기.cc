#include <bits/stdc++.h>
using namespace std;


/**
 * state: n, value: 방법의 수
 */

int dp[12];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= 10; i++) {
        dp[i] += dp[i - 1];
        dp[i] += dp[i - 2];
        dp[i] += dp[i - 3]; 
    }

    int t; cin >> t;
    while (t--) {
        int n; cin >> n;
        cout << dp[n] << '\n';
    }
}