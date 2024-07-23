#include <bits/stdc++.h>
using namespace std;

// 방향 그래프
// 최소 길이 사이클 찾기
// 경로를 찾을 수 없으면 -1 출력

const int INF = 0x3f3f3f3f;
int dist[401][401];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, a, b, c, min = INF;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        fill(dist[i], dist[i] + n + 1, INF);
    }
    while (m--) {
        cin >> a >> b >> c;
        dist[a][b] = c;
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        if (min > dist[i][i]) min = dist[i][i];
    }
    cout << ((min == INF) ? -1 : min);
}