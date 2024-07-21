#include <bits/stdc++.h>
using namespace std;

int adj[101][101];
int dist[101][101];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
const int MAX = 0x3f3f3f3f;

int main(void) {
    int n, m;
    scanf("%d %d", &m, &n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &adj[i][j]);
            dist[i][j] = MAX;
        }
    }
    queue<pair<int, int>> Q;
    Q.push({0, 0});
    dist[0][0] = 0;
    while (!Q.empty()) {
        auto [x, y] = Q.front();
        Q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (dist[nx][ny] <= dist[x][y] + adj[nx][ny]) continue;
            dist[nx][ny] = dist[x][y] + adj[nx][ny];
            Q.push({nx, ny});
        }
    }
    printf("%d", dist[n - 1][m - 1]);
}