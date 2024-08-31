#include <bits/stdc++.h>
using namespace std;

// 별(노드)를 최소 비용으로 이어야 한다(= 트리를 만들어야 한다) --> MST 활용

pair<float, float> star[101];
vector<pair<float, pair<float, float>>> edges;

int n;
int parent[101];
float cost = 0;

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

inline float GetDistance(const pair<float, float>& a, const pair<float, float>& b) {
    return sqrt(pow(a.first - b.first, 2) + pow(a.second - b.second, 2));
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cout << fixed;
    cout.precision(2);

    cin >> n;
    for (int i = 1; i <= n; i++) parent[i] = i;
    for (int i = 1; i <= n; i++) cin >> star[i].first >> star[i].second;

    for (int i = 1; i < n; i++) {
        for (int j = i + 1; j <= n; j++) edges.push_back({GetDistance(star[i], star[j]), {i, j}});
    }

    sort(edges.begin(), edges.end());
    for (auto edge : edges) {
        if (find(edge.second.first) != find(edge.second.second)) {
            merge(edge.second.first, edge.second.second);
            cost += edge.first;
        }
    }
    cout << cost;
}