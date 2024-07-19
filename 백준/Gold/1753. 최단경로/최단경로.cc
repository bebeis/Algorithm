#include <bits/stdc++.h>
using namespace std;

// 방향 그래프
int v, e, start;
// (weight, vertex) --> heap에서 weight순으로 정렬될 수 있도록
vector<pair<int, int>> adj[20002]; 
int d[20002];
const int INF = 1e9+10;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    cin >> v >> e >> start;
    fill(d, d + v + 1, INF);
    while (e--) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({w, v});
    }
    d[start] = 0;
    pq.push({0, start});
    while (!pq.empty()) {
        // cw : current weight, cv : current vertex
        auto [cw, cv] = pq.top();
        pq.pop();
        if (d[cv] != cw) continue; // 최소 경로가 아닌 경우
        for (auto [nw, nv] : adj[cv]) {
            // nw : next weight, nv : next vertex
            if (d[nv] <= nw + d[cv]) continue;
            d[nv] = nw + d[cv];
            pq.push({d[nv], nv});
        }
    }
    for (int i = 1; i <= v; i++) {
        if (d[i] == INF) cout << "INF\n";
        else cout << d[i] << '\n';
    }
}