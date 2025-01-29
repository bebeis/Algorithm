#include <bits/stdc++.h>
using namespace std;

// 틀린이유 : std:fill을 까먹음
// std::fill( )​​ 이 때 주의할 점은 배열의 끝 주소의 바로 앞 원소까지만 변경이 적용된다는 것.

int dx[] = {2, 1, -1, -2, -2, -1, 1, 2};
int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int t; cin >> t;
    while (t--) {
        int dist[301][301];
        int l; cin >> l;
        for (int i = 0; i < l; i++) fill(dist[i], dist[i] + l, -1);
        int rx, ry; cin >> rx >> ry;
        int tx, ty; cin >> tx >> ty;
        queue<pair<int, int>> Q;
        Q.push({rx, ry});
        dist[rx][ry] = 0;
        while (dist[tx][ty] == -1) {
            auto [cx, cy] = Q.front();
            Q.pop();

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                if (dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cx][cy] + 1;
                Q.push({nx, ny});
            }
        }
        cout << dist[tx][ty] << '\n';
    }
}