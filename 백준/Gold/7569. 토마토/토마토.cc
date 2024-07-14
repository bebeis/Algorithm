#include <bits/stdc++.h>
using namespace std;

// 7576 토마토 문제의 3차원 버전

int adj[101][101][101];
bool vis[101][101][101];
int dist[101][101][101];
// 아래층, 위층, 아래, 오른쪽, 위, 왼쪽 순서
int dx[6] = { 0, 0, 1, 0, -1, 0 };
int dy[6] = { 0, 0, 0, 1, 0, -1 };
int dz[6] = { 1, -1, 0, 0, 0, 0 };

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, h;
    tuple<int, int, int> cur; // (x, y, z)
    queue<tuple<int, int, int>> Q;
    cin >> m >> n >> h;
    for (int z = 0; z < h; z++) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                cin >> adj[z][x][y];
            }
        }
    }

    // BFS 출발 점 체크
    for (int z = 0; z < h; z++) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (adj[z][x][y] == 1 && !vis[z][x][y]) {
                    Q.push({x, y, z});
                }
            }
        }
    }

    // BFS
    while (!Q.empty()) {
        cur = Q.front();
        Q.pop();

        for (int i = 0; i < 6; i++) {
            int nx = get<0>(cur) + dx[i];
            int ny = get<1>(cur) + dy[i];
            int nz = get<2>(cur) + dz[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
            if (!vis[nz][nx][ny] && adj[nz][nx][ny] == 0) {
                vis[nz][nx][ny] = 1;
                dist[nz][nx][ny] = dist[get<2>(cur)][get<0>(cur)][get<1>(cur)] + 1;
                Q.push({nx, ny, nz});
            }
        }
    }

    // 토마토가 모두 익지 못하는 상황을 체크
    for (int z = 0; z < h; z++) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (!vis[z][x][y] && !adj[z][x][y]) {
                    cout << -1;
                    return 0;
                }
            }
        }
    }

    cout << dist[get<2>(cur)][get<0>(cur)][get<1>(cur)];
}