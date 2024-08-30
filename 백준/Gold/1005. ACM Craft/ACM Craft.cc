#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int t; cin >> t;
    while (t--) {
        int n, k, w;
        cin >> n >> k;
        vector<int> d(n + 1);
        vector<int> adj[1001];
        vector<int> time(n + 1, 0);
        int indeg[1001];
        for (int i = 1; i <= n; i++) {
            cin >> d[i];
            time[i] = d[i];
        }
        while (k--) {
            int v, e;
            cin >> v >> e;
            adj[v].push_back(e);
            indeg[e]++;
        }
        cin >> w; // 건설해야 할 건물 번호
        queue<int> q;
        for (int i = 1; i <= n; i++) if (indeg[i] == 0) q.push(i);
        while (!q.empty()) {
            int cur = q.front(); q.pop();
            for (int nxt : adj[cur]) {
                time[nxt] = max(time[cur] + d[nxt], time[nxt]);
                indeg[nxt]--;
                if (indeg[nxt] == 0) q.push(nxt);
            }
        }

        cout << time[w] << '\n';

    }
}