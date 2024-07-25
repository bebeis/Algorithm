#include <bits/stdc++.h>
using namespace std;

// 최장거리 버전 벨만 포드
// 사이클이 존재할 수 있음 --> 벨만 포드
// idea : 사이클에서 도착지에 갈 수 있을 때 Gee를 출력
// 틀렸던 부분 : 단순히 벨만 포드 후 도착거리랑, 사이클 한 번 더 돌리고 도착거리랑 비교해서 틀림
struct edge {
    int st;
    int ed;
    int weight;
};

const int NINF = -1e9 + 10;
vector<int> adj[51];
bool vis[51];

bool checkCycle(int st, int target) {
    memset(vis, 0, sizeof(vis));
    queue<int> Q;
    Q.push(st);
    vis[st] = 1;
    while (!Q.empty()) {
        int cur = Q.front();
        Q.pop();
        for (int next : adj[cur]) {
            if (next == target) return true;
            if (vis[next]) continue;
            vis[next] = true;
            Q.push(next);
        }
    }
    return false;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, st, ed, u, v, w, m;
    cin >> n >> st >> ed >> m;
    vector<edge> edges(m);
    vector<long long> dist(n + 1, NINF);
    vector<int> incomes(n + 1);
    for (int i = 0; i < m; i++) {
        cin >> u >> v >> w;
        edges[i] = {u, v, w};
        adj[u].push_back(v);
    }
    for (int i = 0; i < n; i++) {
        cin >> incomes[i];
    }

    dist[st] = incomes[st];
    for (int i = 0; i < n - 1; i++) {
        for (auto& edge : edges) {
            if (dist[edge.st] == NINF) continue;
            if (dist[edge.ed] < dist[edge.st] - edge.weight + incomes[edge.ed])
                dist[edge.ed] = dist[edge.st] - edge.weight + incomes[edge.ed];
        }
    }

    if (dist[ed] == NINF) {
        cout << "gg";
        return 0;
    }

    bool cycle = false;
    for (auto& edge : edges) {
        if (dist[edge.st] == NINF) continue;
        if (dist[edge.ed] < dist[edge.st] - edge.weight + incomes[edge.ed]) {
            if (checkCycle(edge.st, ed)) cycle = true;
        }
    }
    if (cycle) {
        cout << "Gee";
    } else {
        cout << dist[ed];
    }
}