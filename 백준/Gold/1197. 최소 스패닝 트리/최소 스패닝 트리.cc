#include <bits/stdc++.h>
using namespace std;

int parent[10001];
vector<pair<int, pair<int, int>>> edges;

// find
int find(int x) {
    if (x == parent[x]) return x;
    else return parent[x] = find(parent[x]);
}
// union
void merge(int a, int b) {
    int x = find(a);
    int y = find(b);
    if (x == y) return;
    parent[y] = x; // y -> x
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int v, e;
    long long result = 0;
    cin >> v >> e;
    while (e--) {
        int st, ed, weight;
        cin >> st >> ed >> weight;
        edges.push_back({weight, {st, ed}});
    }
    sort(edges.begin(), edges.end());
    for (int i = 1; i <= v; i++) parent[i] = i;
    for (auto edge : edges) {
        if (find(edge.second.first) != find(edge.second.second)) {
            merge(edge.second.first, edge.second.second);
            result += edge.first;
        }
    }
    cout << result;
}