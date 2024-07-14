#include <bits/stdc++.h>
using namespace std;

int adj[301][301];
int adj_after[301][301];
bool vis[301][301];

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int n, m;

void BFS(int x, int y) {
    queue<pair<int, int>> Q;
    Q.push({x, y});
    vis[x][y] = 1;

    while (!Q.empty()) {
        auto cur = Q.front();
        Q.pop();
        int tmp = 0;
        for (int j = 0; j < 4; j++) {
            int nx = cur.first + dx[j];
            int ny = cur.second + dy[j];
            if (!adj[nx][ny]) {
                tmp++;
            }
        }
        if (adj[cur.first][cur.second] - tmp < 0) {
            adj_after[cur.first][cur.second] = 0;
        } else {
            adj_after[cur.first][cur.second] = adj[cur.first][cur.second] - tmp;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx <= 0 || nx >= n || ny <= 0 || ny >= m) continue; 
            if (!vis[nx][ny] && adj[nx][ny]) {
                vis[nx][ny] = 1;
                Q.push({nx, ny});
            }
        }
    }
}

void BFS_after(int x, int y) {
    queue<pair<int, int>> Q;
    Q.push({x, y});
    vis[x][y] = 1;

    while (!Q.empty()) {
        auto cur = Q.front();
        Q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx <= 0 || nx >= n - 1 || ny <= 0 || ny >= m - 1) continue;
            if (!vis[nx][ny] && adj_after[nx][ny]) {
                vis[nx][ny] = 1;
                Q.push({nx, ny});
            }
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int x;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> x;
            adj_after[i][j] = adj[i][j] = x;
        }
    }
    int years = 0;
    while (true) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (adj[i][j] && !vis[i][j]) {
                    BFS(i, j);
                }
            }
        }
        memset(vis, 0, sizeof(vis));
        bool water = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (adj_after[i][j] && !vis[i][j]) {
                    BFS_after(i, j);
                    count++;
                    water = false;
                }
            }
        }
        if (water) {
            years = 0; // 요거 빼먹어서 틀림
            break;
        }
        years++;
        if (count >= 2) {
            break;
        }
        memcpy(adj, adj_after, sizeof(adj));
        memset(vis, 0, sizeof(vis));
    }
    cout << years;
}