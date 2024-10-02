#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int T; cin >> T;
    while (T--) {
        int n, m; 
        cin >> n;
        vector<int> lt(n + 1);
        vector<int> indeg(n + 1, 0);
        vector<int> result;
        unordered_set<int> adj[501];
        bool ambigous = false;
        for (int i = 1; i <= n; i++) cin >> lt[i];
        for (int i = n; i > 1; i--) {
            for (int j = i - 1; j >= 1; j--) {
                adj[lt[i]].insert(lt[j]);
                indeg[lt[j]]++;
            }
        }

        cin >> m;
        while (m--) {
            int a, b;
            cin >> a >> b;
            if (adj[a].contains(b)) { // a -> b면 b -> a로 바꾼다.
                adj[a].erase(b);
                adj[b].insert(a);
                indeg[b]--; indeg[a]++;
            } else { // b -> a면 a -> b로 바꾼다.
                adj[b].erase(a);
                adj[a].insert(b);
                indeg[a]--; indeg[b]++;
            }
        }

        queue<int> Q;
        for (int i = 1; i <= n; i++) {
            if (!indeg[i]) {
                Q.push(i);
            }
        }

        while (!Q.empty()) {
            int cur = Q.front();
            Q.pop(); result.push_back(cur);

            int cnt = 0;
            for (auto nxt : adj[cur]) {
                if (--indeg[nxt] == 0) {
                    Q.push(nxt);
                    cnt++;
                }
            }
            if (cnt > 1) {
                ambigous = true;
                break;
            }
        }
        if (ambigous) cout << "?\n";
        else if (result.size() != n) cout << "IMPOSSIBLE\n";
        else {
            for (int i = n - 1; i >= 0; i--) cout << result[i] << " ";
            cout << '\n';
        }
    }
}