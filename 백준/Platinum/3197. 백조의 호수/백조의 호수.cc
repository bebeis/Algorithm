#include <bits/stdc++.h>
using namespace std;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

char adj[1501][1501];
bool vis[1501][1501];
int r, c, cnt = 0;

queue<pair<int, int>> water, next_water, Q, next_Q;
vector<pair<int, int>> swan;

bool BFS_swan() {
    while (!Q.empty()) {
        auto [x, y] = Q.front();
        Q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if (vis[nx][ny]) continue;
            if (nx == swan[1].first && ny == swan[1].second) {
                return true;
            } else if (adj[nx][ny] != 'X') {
                vis[nx][ny] = 1;
                Q.push({nx, ny});
            } else {
                vis[nx][ny] = 1;
                next_Q.push({nx, ny});
            }
        }
    }
    return false;
}

void BFS_water() {
    while (!water.empty()) {
        auto [x, y] = water.front();
        water.pop();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if (adj[nx][ny] == 'X') {
                next_water.push({nx, ny});
                adj[nx][ny] = '.';
            }
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    char k;
    cin >> r >> c;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cin >> k;
            adj[i][j] = k;
            if (k == 'L') {
                swan.push_back({i, j});
                water.push({i, j});
            } else if (k == '.') {
                water.push({i, j});
            }
        }
    }
    vis[swan[0].first][swan[0].second] = 1;
    Q.push(swan[0]);
    while (true) {
        // 백조가 만날 수 있는지 체크
        if (BFS_swan()) break;
        // 메모이제이션을 통해 얻은 백조의 이동경로를 다음 BFS로 설정
        BFS_water();
        // 내일 물이 되는 빙하 영역에 대해 BFS 출발점 설정
        Q = next_Q;
        water = next_water;
        while (!next_Q.empty()) next_Q.pop();
        while (!next_water.empty()) next_water.pop();
        cnt++;
    }
    cout << cnt;
}
