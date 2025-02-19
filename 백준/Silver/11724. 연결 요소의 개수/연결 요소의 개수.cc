#include <bits/stdc++.h>
using namespace std;

vector<int> adj[1002];
bool vis[1002];
int n, m;

void dfs(int cur) {
    vis[cur] = 1;
    for (int nxt : adj[cur]) {
        if (vis[nxt]) continue;
        dfs(nxt);
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    while (m--) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        if (vis[i]) continue;
        dfs(i);
        cnt++;
    }
    cout << cnt;
}