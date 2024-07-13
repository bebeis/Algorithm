#include <bits/stdc++.h>
using namespace std;

// 지나야 하는 최소의 칸 수 --> BFS로 접근
// 문제 조건의 경계에 주의하자
int n, m;
int adj[102][102];
bool vis[102][102];
int dist[102][102];

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main(void) {
    queue<pair<int, int>> Q;
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &adj[i][j]);
        }
    }
    vis[0][0] = 1;
    dist[0][0] = 1;
    Q.push({0, 0});

    while (!Q.empty()) {
        auto cur = Q.front();
        Q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (adj[nx][ny] && !vis[nx][ny]) {
                vis[nx][ny] = 1;
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
                Q.push({nx, ny});
            }
        }
    }
    printf("%d", dist[n - 1][m - 1]);
}