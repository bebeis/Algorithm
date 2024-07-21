#include <bits/stdc++.h>
using namespace std;

int adj[126][126];
int dist[126][126];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
const int INF = 0x3f3f3f3f;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int p = 1;
    while (1) {
        int n;
        cin >> n;
        if (n == 0) break;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> adj[i][j];
                dist[i][j] = INF;
            }
        }
        queue<pair<int, int>> Q;
        Q.push({0, 0});
        dist[0][0] = adj[0][0];
        while (!Q.empty()) {
            auto [x, y] = Q.front();
            Q.pop();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (dist[nx][ny] <= dist[x][y] + adj[nx][ny]) continue;
                dist[nx][ny] = dist[x][y] + adj[nx][ny];
                Q.push({nx, ny});
            }
        }
        cout << "Problem " << p << ": " << dist[n - 1][n - 1] << '\n';
        p++;
    }
}