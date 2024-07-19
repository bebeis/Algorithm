#include <bits/stdc++.h>
using namespace std;

const int INF = 0x3f3f3f3f;
int d[102][102];

// 플로이드(All Pair Shortest Path, ASP 문제)
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, a, b, c;
    cin >> n >> m;
    // 대각선(자기 자신)은 0으로, 나머지는 OF가 발생하지 않는 최댓값으로 초기화
    for (int i = 1; i <= n; i++) {
        fill(d[i], d[i] + 1 + n, INF);
        d[i][i] = 0;
    }
    // input
    while (m--) {
        cin >> a >> b >> c;
        if (d[a][b] > c) {
            d[a][b] = c;
        }
    }
    // ASP 해결
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // D[i][j] = min(D[i][j], D[i][k] + D[k][j])
                if (d[i][j] > d[i][k] + d[k][j]) {
                    d[i][j] = d[i][k] + d[k][j];
                }
            }
        }
    }
    // output
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cout << ((d[i][j] == INF) ? 0 : d[i][j]) << " ";
        }
        cout << '\n';
    }
}