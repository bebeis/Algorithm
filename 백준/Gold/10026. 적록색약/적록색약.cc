#include <bits/stdc++.h>
using namespace std;

int n;
char board[101][101];
bool vis[101][101];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int normalCnt = 0;
int abnormalCnt = 0;

void bfs(int x, int y, char c) {
    queue<pair<int, int>> Q;
    Q.push({x, y});
    vis[x][y] = 1;

    while (!Q.empty()) {
        auto [cx, cy] = Q.front();
        Q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (vis[nx][ny] || board[nx][ny] != c) continue;
            vis[nx][ny] = 1;
            Q.push({nx, ny});
        }
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!vis[i][j]) {
                bfs(i, j, board[i][j]);
                normalCnt++;
            }
        }
    }

    memset(vis, 0, sizeof(vis));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == 'R') board[i][j] = 'G';
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!vis[i][j]) {
                bfs(i, j, board[i][j]);
                abnormalCnt++;
            }
        }
    }
    cout << normalCnt << ' ' << abnormalCnt;
}