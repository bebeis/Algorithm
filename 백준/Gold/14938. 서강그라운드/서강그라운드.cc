#include <bits/stdc++.h>
using namespace std;

const int INF = 0x3f3f3f3f;
// 모든 쌍 최단 경로 문제(ASP) 문제
int n, m, r;
int result = 0;
int item_cnt[101];
int d[101][101];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m >> r;
    for (int i = 1; i <= n; i++) cin >> item_cnt[i];
    for (int i = 1; i <= n; i++) {
        fill(d[i] + 1, d[i] + n + 1, INF);
        d[i][i] = 0;
    }
    while (r--) {
        int u, v, w;
        cin >> u >> v >> w;
        if (d[u][v] > w) d[u][v] = d[v][u] = w;
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] > d[i][k] + d[k][j]) {
                    d[i][j] = d[i][k] + d[k][j];
                }
            }
        }
    }

    for (int i = 1; i <= n; i++) {
        int cnt = 0;
        for (int j = 1; j <= n; j++) {
            if (d[i][j] <= m) cnt += item_cnt[j];
        }
        if (result < cnt) result = cnt;
    }

    cout << result;
}