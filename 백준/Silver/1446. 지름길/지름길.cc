#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9+10;
int dist[10001];
vector<pair<int, int>> adj[10001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, d;
    cin >> n >> d;
    fill(dist, dist + d + 1, INF);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    while (n--) {
        int u, v, w;
        cin >> u >> v >> w;
        if (w < v - u) adj[u].push_back({w, v});
    }
    for (int i = 0; i < d; i++) {
        adj[i].push_back({1, i + 1});
    }
    dist[0] = 0;
    pq.push({0, 0});
    while (!pq.empty()) {
        auto [cw, cv] = pq.top();
        pq.pop();
        if (dist[cv] != cw) continue;
        for (auto [nw, nv] : adj[cv]) {
            if (dist[nv] <= nw + dist[cv]) continue;
            dist[nv] = nw + dist[cv];
            pq.push({dist[nv], nv});
        }
    }
    cout << dist[d];
}