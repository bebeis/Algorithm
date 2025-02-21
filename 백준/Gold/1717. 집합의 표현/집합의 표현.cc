#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> parent(1000002, -1);

int find(int x) {
    if (parent[x] < 0) return x;
    return parent[x] = find(parent[x]);
}

bool uni(int u, int v) {
    u = find(u);
    v = find(v);
    if (u == v) return false;

    if (u < v) parent[v] = u;
    else parent[u] = v;
    return true;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    while (m--) {
        int cmd, a, b;
        cin >> cmd >> a >> b;
        if (cmd == 0) {
            uni(a, b);
        } else {
            if (find(a) == find(b)) cout << "YES" << '\n';
            else cout << "NO" << '\n';
        }
    }
}