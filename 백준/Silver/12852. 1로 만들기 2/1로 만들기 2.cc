#include <bits/stdc++.h>
using namespace std;

int dp[1000003];
int before[1000003];
int n;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    dp[1] = 0;
    before[1] = 0;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + 1;
        before[i] = i - 1;
        if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
            dp[i] = dp[i / 2] + 1;
            before[i] = i / 2;
        }
        if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
            dp[i] = dp[i / 3] + 1;
            before[i] = i / 3;
        }
    }
    cout << dp[n] << '\n';
    while (n != 0) {
        cout << n << ' ';
        n = before[n];
    }
}