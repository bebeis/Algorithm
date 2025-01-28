#include <bits/stdc++.h>
using namespace std;

// O(N^2logn)이하로 풀이

int m, n;
int board[1001][1001];
int dist[1001][1001];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    queue<pair<int, int>> Q;
    cin >> m >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
            if (board[i][j] == 1) Q.push({i, j});
        }
    }

    while (!Q.empty()) {
        auto [cx, cy] = Q.front();
        Q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (board[nx][ny] == 0) {
                board[nx][ny] = 1;
                dist[nx][ny] = dist[cx][cy] + 1;
                Q.push({nx, ny});
            }
        }
    }
    int max = -1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == 0) {
                cout << -1;
                return 0;
            }
            if (dist[i][j] > max) max = dist[i][j];
        }
    }
    cout << max;
}