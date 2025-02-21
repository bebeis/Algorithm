#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9+10;
int adj[102][102];
int n, m;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        fill(adj[i] + 1, adj[i] + 1 + n, INF);
        adj[i][i] = 0;
    }
    while (m--) {
        int a, b, c; cin >> a >> b >> c;
        adj[a][b] = min(c, adj[a][b]);
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (adj[i][k] + adj[k][j] < adj[i][j]) {
                    adj[i][j] = adj[i][k] + adj[k][j];
                }
            }
        }
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (adj[i][j] == INF) cout << "0 ";
            else cout << adj[i][j] << ' ';
        }
        cout << '\n';
    }
}