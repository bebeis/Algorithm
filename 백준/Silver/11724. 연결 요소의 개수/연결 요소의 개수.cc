#include <bits/stdc++.h>
using namespace std;

bool vis[1002];
unordered_set<int> sub;
vector<int> adj[1002];

void DFS(int start) {
    vis[start] = 1;
    sub.erase(start);
    for (int i = 0; i < adj[start].size(); i++) {
        int next = adj[start][i];
        if (!vis[next]) {
            DFS(next);
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, count;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int s, e;
        cin >> s >> e;
        adj[s].push_back(e);
        adj[e].push_back(s);
        sub.insert(s);
        sub.insert(e);
    }

    // 정점이 연결되어 있지 않는 부분도 고려해야 한다
    count = n - sub.size();

    while (!sub.empty()) {
        DFS(*sub.begin());
        count++;
    }
    cout << count;
}