#include <bits/stdc++.h>
using namespace std;

int n, m;
int depth[100001];
int ancestor[18][100001]; // 2^17 = 13만. 최대 2^16~2&17
vector<int> adj[100001];

void dfs(int cur, int parent) {
    ancestor[0][cur] = parent;
    for (int next : adj[cur]) {
        if (next != parent) {
            depth[next] = depth[cur] + 1;
            dfs(next, cur);
        }
    }
}

void ancestorDP() {
    for (int k = 1; k < 17; k++) {
        for (int v = 1; v <= n; v++) {
            if (ancestor[k - 1][v] != -1) {
                // 2^(k - 1)씩 두 번 올라가면 2^k 위 조상이 나온다.
                ancestor[k][v] = ancestor[k - 1][ancestor[k - 1][v]];
                continue;
            }
            ancestor[k][v] = -1;
        }
    }
}

int lca(int u, int v) {
    // 일단 u가 더 깊게 설정
    if (depth[u] < depth[v]) swap(u, v);

    // 높이를 같게 맞춘다.
    for (int k = 16; k >= 0; k--) {
        if (depth[u] - (1 << k) >= depth[v]) u = ancestor[k][u];
    }

    // 운 좋게 깊이가 같다면 바로 리턴
    if (u == v) return u;

    // u와 v를 동시에 올리면서 lca를 찾는다.

    for (int k = 16; k >= 0; k--) {
        if (ancestor[k][u] != -1 && ancestor[k][u] != ancestor[k][v]) {
            u = ancestor[k][u];
            v = ancestor[k][v];
        }
    }
    
    return ancestor[0][u];
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    memset(ancestor, -1, sizeof(ancestor));

    dfs(1, -1);
    ancestorDP();
    
    cin >> m;
    while (m--) {
        int u, v;
        cin >> u >> v;
        cout << lca(u, v) << '\n';
    }
}