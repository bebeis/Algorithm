#include <bits/stdc++.h>
using namespace std;

int end_node;
int length = -1;
vector<pair<int, int>> adj[100001];
bool visited[100001];

void dfs(int parent, int cur) {
    if (cur > length) {
        end_node = parent;
        length = cur;
    }
    for (auto [child, weight] : adj[parent]) {
        if (visited[child]) continue;
        visited[child] = true;
        dfs(child, cur + weight);
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int v;
    cin >> v;
    for (int i = 0; i < v; i++) {
        int st, ed, weight;
        cin >> st >> ed;
        while (ed != -1) {
            cin >> weight;
            adj[st].push_back({ed, weight});
            cin >> ed;
        }
    }
    visited[1] = 1;
    dfs(1, 0);

    memset(visited, 0, sizeof(visited));
    visited[end_node] = 1;
    length = -1;
    dfs(end_node, 0);

    cout << length;
}