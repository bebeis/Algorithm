#include <bits/stdc++.h>
using namespace std;

// SSP 문제 --> 다익스트라
const int INF = 1e9+10;
vector<pair<int, int>> adj[1001];
int d[1001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, st, ed;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    cin >> n >> m;
    fill(d, d + n + 1, INF);
    while (m--) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({w, v});
    }
    cin >> st >> ed;
    d[st] = 0;
    pq.push({0, st});
    while (!pq.empty()) {
        auto [cw, cv] = pq.top();
        pq.pop();
        if (d[cv] != cw) continue;
        for (auto [nw, nv] : adj[cv]) {
            if (d[nv] <= d[cv] + nw) continue;
            d[nv] = d[cv] + nw;
            pq.push({d[nv], nv});
        }
    }
    cout << d[ed];
}