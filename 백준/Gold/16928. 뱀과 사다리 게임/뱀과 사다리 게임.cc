#include <bits/stdc++.h>
using namespace std;

// 주사위를 최소 몇 번 굴려야 하는지 --> 가중치가 같음 --> BFS
int n, m;
int ladders[101];
int snakes[101];
bool visited[101];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        ladders[x] = y;
    }
    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        snakes[x] = y;
    }
    queue<pair<int, int>> Q; // 현재 위치, 던진 횟수
    Q.push({1, 0});
    visited[1] = 1;
    while (!Q.empty()) {
        auto [cur, cnt] = Q.front();
        Q.pop();

        if (ladders[cur]) cur = ladders[cur];
        else if (snakes[cur]) cur = snakes[cur];

        if (cur == 100) {
            cout << cnt;
            return 0;
        }

        for (int i = 1; i <= 6; i++) {
            if (cur + i > 100) break;
            if (visited[cur + i]) continue;
            Q.push({cur + i, cnt + 1});
            visited[cur + i] = 1;
        }
    }
}