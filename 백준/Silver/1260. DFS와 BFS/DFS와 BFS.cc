#include <bits/stdc++.h>
using namespace std;

const int MAX = 1001;
bool vis[MAX];

vector<int> adj[MAX];
vector<int> visit_order_dfs;
vector<int> visit_order_bfs;

void DFS(int start) {
    vis[start] = 1;
    visit_order_dfs.push_back(start);
    for (int i = 0; i < adj[start].size(); i++) {
        int next = adj[start][i];
        if (!vis[next]) {
            DFS(next);
        }
    }
    
}

void BFS(int start) {
    memset(vis, 0, sizeof(vis));
    queue<int> Q;
    vis[start] = 1;
    Q.push(start);
    
    while (!Q.empty()) {
        int cur = Q.front();
        Q.pop();
        visit_order_bfs.emplace_back(cur);

        for (int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur][i];
            if (!vis[next]) {
                vis[next] = 1;
                Q.push(next);
            }
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, v, s, e;
    cin >> n >> m >> v;
    for (int i = 0; i < m; i++) {
        cin >> s >> e;
        adj[s].emplace_back(e);
        adj[e].emplace_back(s);
    }

    for (int i = 1; i <= n; i++) {
        sort(adj[i].begin(), adj[i].end());
    }
    DFS(v); BFS(v);
    for (auto x : visit_order_dfs) {
        cout << x << " ";
    }
    cout << '\n';
    for (auto x : visit_order_bfs) {
        cout << x << " ";
    }
}