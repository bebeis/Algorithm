#include <bits/stdc++.h>
using namespace std;


// 리프 노드 중에서 두 개를 고른 뒤에 부모까지 거리의 합을 구한 것의 최댓값

int n;
int max_length = 0;
int end_node;
vector<pair<int, int>> adj[10001];
int visited[10001];

void dfs(int parent, int length) {
    if (visited[parent]) return;
    visited[parent] = 1;
    if (max_length < length) {
        max_length = length;
        end_node = parent;
    }

    for (auto [child, weight] : adj[parent]) {
        dfs(child, length + weight);
    }
    // case 1 : 현재 부모부터 다시 시작

    // case 2 : 현재 부모를 거쳐간다.
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;

    for (int i = 0; i < n - 1; i++) {
        int p, c, w;
        cin >> p >> c >> w;
        adj[p].push_back({c, w});
        adj[c].push_back({p, w});
    }

    dfs(1, 0);
    memset(visited, 0, sizeof(visited));
    dfs(end_node, 0);

    cout << max_length;
}