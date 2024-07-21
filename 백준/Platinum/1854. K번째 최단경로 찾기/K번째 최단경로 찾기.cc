#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> adj[1002];
priority_queue<int> dist[1002];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, m, k, limit;
    cin >> n >> m >> k;
    while (m--) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({w, v});
    }
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    dist[1].push(0);
    pq.push({0, 1});
    while (!pq.empty()) {
        auto [cw, cv] = pq.top();
        pq.pop();
        for (auto [nw, nv] : adj[cv]) {
            if (dist[nv].size() < k) {
                dist[nv].push(cw + nw);
                pq.push({cw + nw, nv});
            } else if (dist[nv].top() > cw + nw) {
                dist[nv].pop(); // 최댓값 제거
                dist[nv].push(cw + nw);
                pq.push({cw + nw, nv});
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        if (dist[i].size() < k) {
            cout << "-1\n";
        } else {
            while (dist[i].size() != k) dist[i].pop();
            cout << dist[i].top() << '\n';
        }
    }
}