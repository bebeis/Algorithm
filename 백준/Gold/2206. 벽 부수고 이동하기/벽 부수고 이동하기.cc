#include <bits/stdc++.h>
using namespace std;

int board[1001][1001];
int dist[2][1001][1001];

const int dx[] = {1, 0, -1, 0};
const int dy[] = {0, 1, 0, -1};

int main(void) {
    int n, m;
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%1d", &board[i][j]);

    queue<tuple<int, int, int>> q;
    q.push({0, 0, 0});
    dist[0][0][0] = 1;

    while (!q.empty()) {
        auto [cnt, cx, cy] = q.front();
        q.pop();

        if (cx == n - 1 && cy == m - 1) {
            printf("%d", dist[cnt][cx][cy]);
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            int ncnt = cnt + board[nx][ny];
            if (ncnt > 1 || dist[ncnt][nx][ny]) continue;

            dist[ncnt][nx][ny] = dist[cnt][cx][cy] + 1;
            q.push({ncnt, nx, ny});
        }
    }
    printf("-1");
    return 0;
}