#include <bits/stdc++.h>
using namespace std;

int n, m;
double length = 0;

pair<int, int> gods[1001];
vector<pair<double, pair<int, int>>> edges; // dist, {st, ed}
pair<int, int> connected[1001];

int parent[1001];

int find(int x) {
    if (x == parent[x]) return x;
    return parent[x] = find(parent[x]);
}

void merge(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) return;
    parent[b] = a;
}

inline double getDistance(const pair<int, int>& lhs, const pair<int, int>& rhs) {
    double dist = pow(lhs.first - rhs.first, 2) + pow(lhs.second - rhs.second, 2);
    return sqrt(dist);
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cout << fixed;
    cout.precision(2);
    cin >> n >> m;
    for (int i = 1; i <= n; i++) parent[i] = i;
    for (int i = 1; i <= n; i++) cin >> gods[i].first >> gods[i].second;
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        merge(u, v);
    }

    for (int i = 1; i < n; i++) {
        for (int j = i + 1; j <= n; j++) {
            edges.push_back({getDistance(gods[i], gods[j]), {i, j}});
        }
    }
    sort(edges.begin(), edges.end());
    for (auto edge : edges) {
        if (find(edge.second.first) != find(edge.second.second)) {
            merge(edge.second.first, edge.second.second);
            length += edge.first;
        }
    }
    cout << length;
}