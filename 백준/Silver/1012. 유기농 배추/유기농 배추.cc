#include <bits/stdc++.h>
using namespace std;

// 문제 해결 idea : 임의 한 점에서 출발하여 scrach가 끝나면, 방문하지 않은 점부터 다시 시작(모든 점을 방문할 때 까지)
// DFS 사용
// 그래프 자료구조가 필요 없고 인접한 곳에 몰려 있으므로 adj matrix 사용

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int adj[51][51];

int t, n, m, k; // 테스트 케이스 : t, 세로 : n, 가로 : m, 노드 개수 : k

void DFS(int x, int y) {
    adj[x][y] = 0;
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if (adj[nx][ny]) {
            DFS(nx, ny);
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    cin >> t;
    while (t--) {
        cin >> m >> n >> k;
        int s, e, count = 0; // e : rows, s : cols
        for (int i = 0; i < k; i++) {
            cin >> s >> e; // [e][s]
            adj[e][s] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (adj[i][j]){
                    DFS(i, j);
                    count++;
                }
            }
        }
        cout << count << '\n';
    }
}