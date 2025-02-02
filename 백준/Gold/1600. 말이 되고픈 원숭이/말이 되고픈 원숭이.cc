#include <bits/stdc++.h>
using namespace std;

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int dhx[] = {2, 1, -1, -2, -2, -1, 1, 2};
int dhy[] = {1, 2, 2, 1, -1, -2, -2, -1};

int k, w, h;
int board[202][202];
int dist[202][202][32];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> k >> w >> h;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            cin >> board[i][j];
            fill(dist[i][j], dist[i][j] + k + 1, -1);
        }
    }

    queue<pair<pair<int, int>, int>> Q;
    Q.push({{0, 0}, 0});
    dist[0][0][0] = 0;

    while (!Q.empty()) {
        int cx = Q.front().first.first;
        int cy = Q.front().first.second;
        int ck = Q.front().second;
        Q.pop();

        if (cx == h - 1 && cy == w - 1) {
            cout << dist[cx][cy][ck];
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if (board[nx][ny] == 1) continue;
            bool skip = false;
            for (int j = ck; j >= 0; j--) {
                if (dist[nx][ny][j] != -1 && dist[nx][ny][j] <= dist[cx][cy][ck] + 1) {
                    skip = true;
                    break;
                }
            }
            if (skip) continue;
            dist[nx][ny][ck] = dist[cx][cy][ck] + 1;
            Q.push({{nx, ny}, ck});
        }

        if (ck >= k) continue;
        for (int i = 0; i < 8; i++) {
            int nx = cx + dhx[i];
            int ny = cy + dhy[i];
            int nk = ck + 1;

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if (board[nx][ny] == 1) continue;
            bool skip = false;
            for (int j = nk; j >= 0; j--) {
                if (dist[nx][ny][j] != -1 && dist[nx][ny][j] <= dist[cx][cy][ck] + 1) {
                    skip = true;
                    break;
                }
            }

            if (skip) continue;

            dist[nx][ny][nk] = dist[cx][cy][ck] + 1;
            Q.push({{nx, ny}, nk});
        }
    }
    cout << -1;
}