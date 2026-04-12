#include <bits/stdc++.h>
using namespace std;

int indeg[32002];
vector<int> adj[32002];

int main() {
    cin.tie(0) -> sync_with_stdio(false);
    int n, m; cin >> n >> m;
    
    while (m-- > 0) {
        int a, b; cin >> a >> b;
        indeg[b]++;

        adj[a].push_back(b);
    }

    queue<int> q;
    for (int i = 1; i <= n; i++) {
        if (indeg[i] == 0) q.push(i);
    }

    while (!q.empty()) {
        auto cur = q.front();
        q.pop();
        cout << cur << ' ';

        for (int nxt : adj[cur]) {
            if (--indeg[nxt] == 0) q.push(nxt);
        }
    }
}
