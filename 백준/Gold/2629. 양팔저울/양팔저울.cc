#include <bits/stdc++.h>
using namespace std;

// t + { 부분집합 } = { 부분집합 }
// t = { 부분집합의 합 } - {앞 부분집합과 중복되지 않는 부분집합의 합}
// i번째 원소를 앞에 넣을수도 있고, 뒤에 넣을 수도 있다.
// 앞에 넣는 경우를 먼저 처리하고, 뒤에 넣는 경우를 나중에 따로 처리해주면 모든 케이스를 구할 수 있다.
int weight[31];
int n, m;
bool dp[40001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> weight[i];
    dp[0] = 1; // 기저 조건
    for (int i = 1; i <= n; i++) {
        for (int j = 40000; j >= 0; j--) {
            if (dp[j]) dp[j + weight[i]] = 1; 
        }
        for (int j = 0; j <= 40000; j++) {
            if (dp[j]) dp[abs(j - weight[i])] = 1;
        }
    }

    cin >> m;
    while (m--) {
        int t; cin >> t;
        if (dp[t]) cout << "Y ";
        else cout << "N ";
    }

}