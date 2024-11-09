#include <bits/stdc++.h>
using namespace std;

int n;
int board[101][101];
bool visited[101][101];
bool isBoundary[101][101];
int dist[101][101];
int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };
int id = 2;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    vector<pair<int ,int>> lands;
    queue<pair<int, int>> boundQue;
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
            if (board[i][j] == 1) {
                lands.push_back({i, j});
            }
        }
    }

    for (auto [x, y] : lands) {
        if (board[x][y] > 1) continue;
        queue<pair<int, int>> travelQue;
        travelQue.push({x, y});
        visited[x][y] = 1;
        board[x][y] = id;
        while (!travelQue.empty()) {
            auto [cx, cy] = travelQue.front();
            travelQue.pop();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] == 0 && !isBoundary[cx][cy]) {
                    boundQue.push({cx, cy});
                    isBoundary[cx][cy] = 1;
                }
                if (board[nx][ny] == 1 && !visited[nx][ny]) {
                    board[nx][ny] = id;
                    visited[nx][ny] = 1;
                    travelQue.push({nx, ny});
                }
            }
        }
        id++;
    }

    while (!boundQue.empty()) {
        auto [cx, cy] = boundQue.front();
        boundQue.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (board[nx][ny] == board[cx][cy]) continue;


            board[nx][ny] = board[cx][cy];
            dist[nx][ny] = dist[cx][cy] + 1;
            
            boundQue.push({nx, ny});

            for (int j = 0; j < 4; j++) {
                int nnx = nx + dx[j];
                int nny = ny + dy[j];

                if (nnx < 0 || nnx >= n || nny < 0 || nny >= n) continue;
                if (board[nnx][nny] != 0 && board[nnx][nny] != board[nx][ny]) {
                    cout << dist[nx][ny] + dist[nnx][nny];
                    return 0;
                }
            }
        }
    }
}