#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> adj[1002];
int d[1002];
int pre[1002];
const int INF = 1e9+10;

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
            pre[nv] = cv;
        }
    }

    cout << d[ed] << '\n';
    vector<int> path;
    int k = ed;
    while (k != st) {
        path.push_back(k);
        k = pre[k];
    }
    path.push_back(st);
    cout << path.size() << '\n';
    for (vector<int>::reverse_iterator rit(path.rbegin()); rit != path.rend(); ++rit) {
        cout << *rit << " ";
    }
}