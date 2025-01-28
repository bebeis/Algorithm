#include <bits/stdc++.h>
using namespace std;

int board[501][501];
bool vis[501][501];

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int cnt = 0;
int maxArea = 0;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int n, m; cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (vis[i][j] || board[i][j] == 0) continue;
            queue<pair<int, int>> Q;
            Q.push({i, j}); vis[i][j] = 1;
            cnt++;
            int area = 0;
            while (!Q.empty()) {
                auto [cx, cy] = Q.front();
                Q.pop();
                area++;

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (vis[nx][ny] || !board[nx][ny]) continue;
                    vis[nx][ny] = 1;
                    Q.push({nx, ny});
                }
            }
            maxArea = max(maxArea, area);
        }
    }
    cout << cnt << '\n' << maxArea;
}