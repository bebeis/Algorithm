#include <bits/stdc++.h>
using namespace std;

// 출발점이 N개 --> 벨만 포드

const int INF = 1e9 + 10;
vector<pair<int, int>> adj[1001];
int dist[1001];
int n, m, x;

void dijkstra(int i) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    fill(dist, dist + n + 1, INF);
    // i가 출발점
    dist[i] = 0;
    pq.push({0, i});
    while (!pq.empty()) {
        auto [cw, cv] = pq.top();
        pq.pop();
        if (dist[cv] != cw) continue;
        for (auto [nw, nv] : adj[cv]) {
            if (dist[nv] <= dist[cv] + nw) continue;
            dist[nv] = dist[cv] + nw;
            pq.push({dist[nv], nv});
        }
    }
}
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int max = -1;
    cin >> n >> m >> x;
    while (m--) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({w, v});
    }
    for (int i = 1; i <= n; i++) {
        // i가 출발점
        dijkstra(i);
        int l1 = dist[x];
        // x가 출발점
        dijkstra(x);
        int l2 = dist[i];
        if (max < (l1 + l2)) max = l1 + l2;
    }
    cout << max;
}