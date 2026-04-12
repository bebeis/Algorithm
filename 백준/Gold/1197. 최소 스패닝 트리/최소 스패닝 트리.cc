#include <bits/stdc++.h>
using namespace std;

int p[10002];
vector<pair<int, pair<int, int>>> edges;

int find(int x) {
    if (p[x] < 0) return x;
    return p[x] = find(p[x]);
}

bool uni(int u, int v) {
    u = find(u); v = find(v);

    if (u == v) return false;

    if (p[v] < p[u]) // y의 랭크가 x보다 큰 경우
        swap(u, v); // x를 더 크게 만든다. 
    if (p[u] == p[v]) p[u]--;
    p[v] = u;
    return true;
}

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    fill(p, p + 10002, -1);

    int v, e; cin >> v >> e;
    while (e-- > 0) {
        int a, b, c; cin >> a >> b >> c;
        edges.push_back({c, {a, b}});
    }

    sort(edges.begin(), edges.end());

    int sum = 0;
    int cnt = 0;
    for (auto [w, l] : edges) {
        if (uni(l.first, l.second)) {
            sum += w;
            cnt++;
        }

        if (cnt == v - 1) break;
    }

    cout << sum;
}
