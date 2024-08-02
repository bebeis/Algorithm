#include <bits/stdc++.h>
using namespace std;

// 풀이 1. 타뷸레이션
// 차원(key)에 대한 value는 해당 차원을 만들기 위한 최소 연산 회수이다.

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    vector<int> dp(n + 1);
    dp[1] = 0;
    // tabulation을 이용 --> for문 또는 while문으로 논리 구현
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + 1;
        if (i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1);
        if (i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1);
    }
    cout << dp[n];
}