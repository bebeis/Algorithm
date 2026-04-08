#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n; cin >> n;
    vector<int> a(n + 1), deg(n + 1, 0);
    for (int i = 1; i <= n; i++) { cin >> a[i]; deg[a[i]]++; }

    queue<int> q;
    for (int i = 1; i <= n; i++) if (!deg[i]) q.push(i);

    int cnt = 0;
    while (!q.empty()) {
        int x = q.front(); q.pop();
        cnt++;
        if (--deg[a[x]] == 0) q.push(a[x]);
    }
    cout << cnt << '\n';
}

int main() {
    cin.tie(0)->sync_with_stdio(false);
    int t; cin >> t;
    while (t--) solve();
}