#include <bits/stdc++.h>
using namespace std;

// Memory Limit : 4MB에 주의하자. nk로는 메모리가 초과할 듯
int dp[10001];
int arr[101];
int n, k;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> k;
    dp[0] = 1;
    for (int i = 1; i <= n; i++) cin >> arr[i];
    // for (int i = 0; i <= k; i++) {
    //     if (dp[i]) {
    //         for (int j = 1; j <= n; j++) dp[i + arr[j]] += dp[i];
    //     }
    // }
    // 위 코드는 n에 대한 for문을 안쪽에 둬서 동전을 뽑는 순서가 경우의 수에 반영됨.

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= k; j++) {
            if (j - arr[i] >= 0) dp[j] += dp[j - arr[i]];
        }
    }
    cout << dp[k];
}