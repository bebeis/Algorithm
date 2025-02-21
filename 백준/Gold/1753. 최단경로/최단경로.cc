#include <bits/stdc++.h>
using namespace std;

int v, e, st;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq; // 비용, nxt
vector<pair<int, int>> adj[20002];
int dist[20002];
const int INF = 1e9 + 10;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> v >> e >> st;
    for (int i = 1; i <= v; i++) dist[i] = INF;
    dist[st] = 0;
    while (e--) {
        int a, b, c; cin >> a >> b >> c;
        adj[a].push_back({c, b});
    }
    pq.push({0, st});
    while (!pq.empty()) {
        auto [cc, cur] = pq.top(); pq.pop();
        if (cc != dist[cur]) continue;

        for (auto [nc, nxt] : adj[cur]) {
            if (dist[cur] + nc >= dist[nxt]) continue;
            dist[nxt] = dist[cur] + nc;
            pq.push({dist[nxt], nxt});
        }
    }
    for (int i = 1; i <= v; i++) {
        if (dist[i] == INF) cout << "INF\n";
        else cout << dist[i] << '\n';
    }
}