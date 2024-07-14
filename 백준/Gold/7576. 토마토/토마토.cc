#include <bits/stdc++.h>
using namespace std;

// 최소 일수 --> BFS
// 마지막 순회에서 거리 값을 출력하면 되는데 굳이 배열 내에서 최댓값을 찾다가 시간초과-> 2트
int adj[1001][1001];
bool vis[1001][1001];
int dist[1001][1001];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, last = 0;
    pair<int, int> cur;
    queue<pair<int, int>> Q;
    cin >> m >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> adj[i][j];
        }
    }

    // BFS 출발 점 체크
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (adj[i][j] == 1 && !vis[i][j]) {
                Q.push({i, j});
            }
        }
    }

    // BFS
    while (!Q.empty()) {
        cur = Q.front();
        Q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (!vis[nx][ny] && adj[nx][ny] == 0) {
                vis[nx][ny] = 1;
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
                Q.push({nx, ny});
            }
        }
    }

    // 토마토가 모두 익지 못하는 상황을 체크
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (!vis[i][j] && !adj[i][j]) {
                cout << -1;
                return 0;
            }
        }
    }
    cout << dist[cur.first][cur.second];
}