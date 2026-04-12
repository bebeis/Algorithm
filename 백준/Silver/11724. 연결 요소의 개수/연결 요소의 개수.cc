#include <bits/stdc++.h>
using namespace std;

vector<int> adj[1002];
bool visited[1002];

int main() {
	cin.tie(0) -> sync_with_stdio(false);

    int n, m; cin >> n >> m;
    while (m-- > 0) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        if (visited[i]) continue;
        queue<int> q;
        q.push(i);
        visited[i] = true;

        while (!q.empty()) {
            auto cur = q.front();
            q.pop();

            for (int nxt : adj[cur]) {
                if (visited[nxt]) continue;
                q.push(nxt);
                visited[nxt] = true;
            }
        }
        cnt++;
    }
    cout << cnt;
}