#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> adj[1001];
int indeg[1001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    while (m--) {
        int cnt;
        cin >> cnt;
        vector<int> singer(cnt);
        for (int i = 0; i < cnt; i++) cin >> singer[i];
        // for (int i = 1; i < cnt; i++) adj[singer[i - 1]].push_back(singer[i]);
        for (int i = 0; i < cnt - 1; i++) {
            for (int j = i + 1; j < cnt; j++) {
                adj[singer[i]].push_back(singer[j]);
                indeg[singer[j]]++;
            }
        }
    }
    vector<int> result;
    queue<int> q;
    for (int i = 1; i <= n; i++) {
        if (indeg[i] == 0) q.push(i);
    }

    while (!q.empty()) {
        int cur = q.front(); q.pop();
        result.push_back(cur);

        for (int nxt : adj[cur]) {
            if (--indeg[nxt] == 0) q.push(nxt);
        }
    }

    if (result.size() == n) {
        for (int num : result) cout << num << '\n';
    } else cout << 0;
}