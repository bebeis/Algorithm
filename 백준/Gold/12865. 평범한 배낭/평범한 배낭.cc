#include <bits/stdc++.h>
using namespace std;

// knapsack 문제
// 물건을 딱 한번만 넣을 수 있음에 주의해야 한다.
int w[101];
int v[101];

int d[101][100001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, k;
    cin >> n >> k;
    for (int i = 1; i <= n; i++) cin >> w[i] >> v[i];
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= k; j++) {
            // i번째 물건을 담는 경우와, 담지 않는 경우 중 최댓값
            if (j >= w[i]) d[i][j] = max(d[i - 1][j - w[i]] + v[i], d[i - 1][j]);
            // i번째 물건을 담지 못하므로
            else d[i][j] = d[i - 1][j];
        }
    }
    cout << d[n][k];
}