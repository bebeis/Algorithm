#include <bits/stdc++.h>
using namespace std;

// ASP 경로 추적
// 무방향 그래프

const int INF = 0x3f3f3f3f;
int dist[201][201];
int nxt[201][201];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, u, v, w;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        fill(dist[i], dist[i] + n + 1, INF);
        dist[i][i] = 0;
    }
    while (m--) {
        cin >> u >> v >> w;
        if (dist[u][v] > w) {
            dist[v][u] = dist[u][v] = w;
            nxt[u][v] = v;
            nxt[v][u] = u;
        }
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                    nxt[i][j] = nxt[i][k];
                }
            }
        }
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (nxt[i][j] == 0 || nxt[i][j] == INF) {
                cout << "- ";
            } else {
                cout << nxt[i][j] << " ";
            }
        }
        cout << '\n';
    }
}
