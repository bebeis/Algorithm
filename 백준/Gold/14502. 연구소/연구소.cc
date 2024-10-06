#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[9][9];
int MAX = 0;
int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };
int wallcnt = 0;
// n과 m이 8이하로 범위가 매우 작고, 문제 시간이 널널함
// --> 브루트 포스로 접근해보자.
// 벽을 치는 모든 경우의 수 최대 64C3


int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    vector<pair<int, int>> empty;
    vector<pair<int, int>> virus;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> board[i][j];
            if (board[i][j] == 0) empty.push_back({i, j});
            if (board[i][j] == 2) virus.push_back({i, j});
            if (board[i][j] == 1) wallcnt++;
        }
    }
    wallcnt += 3;
    for (int i = 0; i < empty.size() - 2; i++) {
        for (int j = i + 1; j < empty.size() - 1; j++) {
            for (int k = j + 1; k < empty.size(); k++) {
                board[empty[i].first][empty[i].second] = 1;
                board[empty[j].first][empty[j].second] = 1;
                board[empty[k].first][empty[k].second] = 1;

                queue<pair<int ,int>> Q;
                bool visited[9][9];
                memset(visited, 0, sizeof(visited));
                for (auto x : virus) {
                    Q.push(x);
                    visited[x.first][x.second] = 1;
                }

                while (!Q.empty()) {
                    auto [cx, cy] = Q.front();
                    Q.pop();

                    for (int i = 0; i < 4; i++) {
                        int nx = cx + dx[i];
                        int ny = cy + dy[i];
                        if (visited[nx][ny]) continue;
                        if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
                        if (board[nx][ny] == 1) continue;
                        Q.push({nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
                int cnt = 0;
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (!visited[i][j]) cnt++;
                    }
                }
                cnt -= wallcnt;
                if (MAX < cnt) MAX = cnt;
                board[empty[i].first][empty[i].second] = 0;
                board[empty[j].first][empty[j].second] = 0;
                board[empty[k].first][empty[k].second] = 0;
            }
        }
    }
    cout << MAX;
}