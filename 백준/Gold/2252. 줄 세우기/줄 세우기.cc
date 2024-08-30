#include <bits/stdc++.h>
using namespace std;

vector<int> adj[32001];
int indeg[32001];
int n, m;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    while (m--) {
        int v, e;
        cin >> v >> e;
        adj[v].push_back(e);
        indeg[e]++;
    }
    queue<int> q;
    for (int i = 1; i <= n; i++) {
        if (indeg[i] == 0) q.push(i);
    }

    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        cout << cur << ' ';
        for (auto nxt : adj[cur]) {
            if (--indeg[nxt] == 0) q.push(nxt);
        }
    }
}