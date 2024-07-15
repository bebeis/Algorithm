#include <bits/stdc++.h>
using namespace std;

// 내가 떠올린 발상 : 1. 출발점에서 이동할 수 없는 칸까지 거리를 저장하고,
// 2. 각 이동할 수 없는 칸에서 도착지까지의 거리를 추정
// 만약 2번과정을 거쳤는데 도착지의 거리가 INT_MAX이면 도착 불가능 한 것, dist[n][m]을 바로 출력(초기값이 -1이라)
int n, m;
int adj[1001][1001];
bool vis[1001][1001];

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int main(void) {
    scanf("%d %d", &n, &m);
    std::vector<std::vector<int>> dist(1001, std::vector<int>(1001, INT_MAX));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &adj[i][j]);
        }
    }

    queue<pair<int, int>> Q;
    Q.push({0, 0});
    vis[0][0] = 1;
    dist[0][0] = 1;
    // 벽까지 도달 거리 포함 순회
    while (!Q.empty()) {
        auto cur = Q.front();
        Q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (!vis[nx][ny] && adj[nx][ny]) {  // 벽에 도달
                vis[nx][ny] = 1;
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
            } else if (!vis[nx][ny] && !adj[nx][ny]) {  // 벽이 아닌 경우
                vis[nx][ny] = 1;
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
                Q.push({nx, ny});
            }
        }
    }
    // 벽에 도달한 칸을 출발지로 설정
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (vis[i][j] && adj[i][j]) {
                Q.push({i, j});
            }
        }
    }
    // 다시 BFS를 도는데, 이동하는 칸이 최단거리가 아닌 경우 순회를 멈춘다.
    while (!Q.empty()) {
        auto cur = Q.front();
        Q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (adj[nx][ny]) continue;
            int ndist = dist[cur.first][cur.second] + 1;
            if (dist[nx][ny] > ndist) {
                dist[nx][ny] = ndist;
                Q.push({nx, ny});
            }
        }
    }
    if (dist[n - 1][m - 1] == INT_MAX) dist[n - 1][m - 1] = -1;
    printf("%d", dist[n - 1][m - 1]);
}