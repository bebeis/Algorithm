#include <bits/stdc++.h>
using namespace std;

// 무방향 그래프, 가중치 1로 fix
const int INF = 0x3f3f3f3f;
int dist[101][101];
int kb[101];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, a, b, min = INT_MAX, min_idx;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        fill(dist[i], dist[i] + n + 1, INF);
        dist[i][i] = 0;
    }
    while (m--) {
        cin >> a >> b;
        dist[a][b] = 1;
        dist[b][a] = 1;
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            kb[i] += dist[i][j];
        }
        if (min > kb[i]) {
            min = kb[i];
            min_idx = i;
        }
    }
    cout << min_idx;
}