#include <bits/stdc++.h>
using namespace std;

int n;
int score[302];
int dp[302];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> score[i];
    }
    dp[0] = 0;
    dp[1] = score[1];
    dp[2] = score[1] + score[2];

    for (int i = 3; i <= n; i++) {
        // i - 2 -> i
        // i - 3 -> i - 1 -> i
        dp[i] = max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
    }
    cout << dp[n];
}