#include <bits/stdc++.h>
using namespace std;

int adj[51][51];
bool vis[51][51];
int n, l, r;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int BFS(int x, int y) {
    queue<pair<int, int>> Q;
    vector<pair<int, int>> union_cell;
    Q.push({x, y});
    vis[x][y] = 1;
    union_cell.push_back({x, y});
    int sum = adj[x][y];

    while (!Q.empty()) {
        pair<int, int> cur = Q.front();
        Q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            int sub = abs(adj[cur.first][cur.second] - adj[nx][ny]);
            if (sub >= l && sub <= r && !vis[nx][ny]) {
                vis[nx][ny] = 1;
                Q.push({nx, ny});
                union_cell.push_back({nx, ny});
                sum += adj[nx][ny];
            }
        }
    }

    int avg = sum / union_cell.size();
    for (auto cell : union_cell) {
        adj[cell.first][cell.second] = avg;
    }

    return union_cell.size();
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> l >> r;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> adj[i][j];
        }
    }

    int days = 0;
    while (true) {
        bool moved = false;
        memset(vis, 0, sizeof(vis));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (BFS(i, j) > 1) {
                        moved = true;
                    }
                }
            }
        }
        if (!moved) break;
        days++;
    }

    cout << days;
}
