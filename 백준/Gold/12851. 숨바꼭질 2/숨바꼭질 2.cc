#include <bits/stdc++.h>
using namespace std;

int back(int x) { return x - 1; }
int front(int x) { return x + 1; }
int teleport(int x) { return 2 * x; }


int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, k, cnt = 0, min_time = INT_MAX;
    queue<pair<int, int>> Q;
    int (*funcArray[3])(int) = {back, front, teleport};
    vector<int> visited(100001, INT_MAX); // 방문한 위치의 최단 시간을 저장

    cin >> n >> k;

    Q.push({n, 0});
    visited[n] = 0;

    while (!Q.empty()) {
        auto cur = Q.front();
        Q.pop();

        if (cur.second >= min_time) { // 현재 시간이 최단 시간을 넘으면 더 볼 필요 없음
            break;
        }

        for (int i = 0; i < 3; i++) {
            int nx = funcArray[i](cur.first);
            if (nx >= 0 && nx <= 100000) {
                if (visited[nx] >= cur.second + 1) { // 현재보다 더 빠른 시간에 도달할 수 있는 경우에만 큐에 추가
                    visited[nx] = cur.second + 1;
                    if (nx == k) {
                        min_time = cur.second + 1;
                        cnt++;
                    } else {
                        Q.push({nx, cur.second + 1});
                    }
                }
            }
        }
    }

    if (n == k) {
        min_time = 0;
        cnt = 1;
    }

    cout << min_time << '\n' << cnt;

    return 0;
}
