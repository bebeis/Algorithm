#include <bits/stdc++.h>
using namespace std;

long long dp[91];

int main(void){
    int n;
    cin >> n;
    dp[1] = 1;
    for (int i = 2; i <= n; i++){
        dp[i] = dp[i - 1] + dp[i - 2]; // 그 전 값 + 그 전전 값
    }
    cout << dp[n];
}
