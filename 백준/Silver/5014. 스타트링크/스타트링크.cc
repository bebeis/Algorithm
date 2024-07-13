#include <bits/stdc++.h>
using namespace std;

// BFS 풀이 (최솟값 찾기 ==> BFS)
bool vis[1000002];

int dist[1000002];

int dx[2];
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int f, s, g, u, d;
    cin >> f >> s >> g >> u >> d;
    dx[0] = u; // 위로 올라가는 경우
    dx[1] = -1 * d; // 아래로 내려가는 경우
    int count = 0; // 버튼을 누른 횟수
    queue<int> Q;
    vis[s] = 1;
    Q.push(s);
    
    while (!Q.empty()) {
        int cur = Q.front();
        if (cur == g) { // 현재 위치가 스타트링크 위치라면
            cout << dist[g];
            return 0;
        }
        Q.pop();

        for (int i = 0; i < 2; i++) {
            int nx = cur + dx[i];
            if (nx <= 0 || nx > f) continue;
            if (!vis[nx]) {
                Q.push(nx);
                vis[nx] = 1;
                dist[nx] = dist[cur] + 1;
            }
        }
    }
    cout << "use the stairs";
}