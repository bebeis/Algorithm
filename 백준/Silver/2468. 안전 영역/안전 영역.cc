#include <bits/stdc++.h>
using namespace std;

int n;
int adj[101][101];
bool vis[101][101];

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

void BFS(int x, int y) {
    queue<pair<int, int>> Q;
    Q.push({x, y});
    vis[x][y] = 1;

    while(!Q.empty()) {
        auto cur = Q.front();
        Q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (adj[nx][ny] && !vis[nx][ny]) {
                vis[nx][ny] = 1;
                Q.push({nx, ny});
            }
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int max = -1; // 안전한 영역 최대 개수
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> adj[i][j];
        }
    }
    for (int k = 0; k <= 100; k++) {
        int count = 0;
        // 방문 배열 reset
        memset(vis, 0, sizeof(vis));
        // 침수 지역 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] == k) {
                    adj[i][j] = 0;
                }
            }
        }
        // 인접해있는 영역을 BFS로 순회
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] && !vis[i][j]) {
                    BFS(i, j);
                    count++;
                }
            }
        }
        if (max < count) max = count;
    }
    cout << max;
}