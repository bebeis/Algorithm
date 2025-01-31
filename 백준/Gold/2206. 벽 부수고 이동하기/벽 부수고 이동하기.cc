#include <bits/stdc++.h>
using namespace std;

int n, m;
char board[1001][1001]; 
int dist_visit[1001][1001][2];
int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> board[i][j];
        }
    }

    queue<pair<pair<int, int>, bool>> Q;
    Q.push({{1, 1}, false});
    dist_visit[1][1][0] = 1; 

    while (!Q.empty()) {
        int x = Q.front().first.first;
        int y = Q.front().first.second;
        bool broken = Q.front().second;
        Q.pop();

        if (x == n && y == m) {
            cout << dist_visit[x][y][broken];
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 배열 범위 체크
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

            if (board[nx][ny] == '1') {
                if (!broken) {
                    if (dist_visit[nx][ny][1] == 0) { // 해당 상태를 방문하지 않았다면
                        dist_visit[nx][ny][1] = dist_visit[x][y][0] + 1;
                        Q.push({{nx, ny}, true});
                    }
                }
            }
            else { // 빈 공간인 경우
                if (dist_visit[nx][ny][broken ? 1 : 0] == 0) { // 현재 상태로 방문하지 않았다면
                    dist_visit[nx][ny][broken ? 1 : 0] = dist_visit[x][y][broken ? 1 : 0] + 1;
                    Q.push({{nx, ny}, broken});
                }
            }
        }
    }

    // 도달 불가능한 경우
    cout << -1;
}
