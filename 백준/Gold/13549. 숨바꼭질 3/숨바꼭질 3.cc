#include <bits/stdc++.h>
using namespace std;

inline int back(int x) {
    return x - 1;
}

inline int front(int x) {
    return x + 1;
}

inline int teleport(int x) {
    return 2 * x;
}

int n, k;
int dist[100001];
const int INF = 1e9+10;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> k;
    int (*fp[3])(int) = {back, front, teleport};

    queue<int> Q;
    fill(dist, dist + 100001, INF);
    dist[n] = 0;
    Q.push(n);
    while(!Q.empty()) {
        int cur = Q.front();
        Q.pop();

        for (int i = 0; i < 3; i++) {
            int nx = fp[i](cur);
            if (nx < 0 || nx > 100000) continue;
            int gap = 1;
            if (i == 2) gap = 0;
            if (dist[nx] <= dist[cur] + gap) continue;
            dist[nx] = dist[cur] + gap;
            if (nx != k) Q.push(nx);
        }
    }
    cout << dist[k];
}