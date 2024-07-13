#include <bits/stdc++.h>
using namespace std;

// 가장 빠른 시간 구하기 : BFS
bool vis[100002];
int dist[100002];

int back(int x) { return x - 1; }
int front(int x) { return x + 1; }
int teleport(int x) { return 2 * x; }

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, k;
    queue<int> Q;
    // 다음 위치를 계산해주는 함수를 편하게 다루기 위해 함수 포인터 배열 사용
    int (*funcArray[3])(int) = {back, front, teleport};
    cin >> n >> k;

    dist[n] = 0;
    Q.push(n);
    vis[n] = 1;

    while (!Q.empty()) {
        int cur = Q.front();
        Q.pop();
        int nx;

        // X -1
        for (int i = 0; i < 3; i++) {
            nx = funcArray[i](cur);
            if (nx >= 0 && nx <= 100000) {
                if (!vis[nx]) {
                    vis[nx] = 1;
                    dist[nx] = dist[cur] + 1;
                    Q.push(nx);
                }
            }
        }
    }
    cout << dist[k];
}