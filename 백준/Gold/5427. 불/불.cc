#include <bits/stdc++.h>
using namespace std;

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
char board[1001][1001];
int fireDist[1001][1001];
int moveDist[1001][1001];

// 1트. fireDist[nx][ny] != -1인 경우에 한해서 불이 퍼졌는지 비교해야 하는데 -1이 아니여야 한다는 조건을 빼먹음
// 2트. 거리 출력하고 개행문자 출력하는 걸 빼먹음

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int t; cin >> t;
    while (t--) {
        queue<pair<int, int>> FQ;
        queue<pair<int, int>> MQ;
        int n, m; cin >> m >> n;
        for (int i = 0; i < n; i++) fill(fireDist[i], fireDist[i] + m, -1);
        for (int i = 0; i < n; i++) fill(moveDist[i], moveDist[i] + m, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> board[i][j];
                if (board[i][j] == '*') {
                    FQ.push({i, j});
                    fireDist[i][j] = 0;
                } else if (board[i][j] == '@') {
                    MQ.push({i, j});
                    moveDist[i][j] = 0;
                }
            }
        }
        
        bool complete = false;
        while (!FQ.empty()) {
            auto [cx, cy] = FQ.front();
            FQ.pop();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#') continue;
                if (fireDist[nx][ny] != -1) continue;
                fireDist[nx][ny] = fireDist[cx][cy] + 1;
                FQ.push({nx, ny});
            }
        }

        while (!MQ.empty()) {
            auto [cx, cy] = MQ.front();
            MQ.pop();

            if (cx == 0 || cx == n - 1 || cy == 0 || cy == m - 1) {
                complete = true;
                cout << moveDist[cx][cy] + 1 << '\n';
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#' || board[nx][ny] == '*') continue;
                if (moveDist[nx][ny] != -1) continue;
                if (fireDist[nx][ny] != -1 && moveDist[cx][cy] + 1 >= fireDist[nx][ny]) continue;
                moveDist[nx][ny] = moveDist[cx][cy] + 1;
                MQ.push({nx, ny});
            }

            if (complete) break;
        }

        if (!complete) cout << "IMPOSSIBLE\n";
    }
}