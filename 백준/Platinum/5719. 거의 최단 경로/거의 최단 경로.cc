#include <bits/stdc++.h>
using namespace std;

// 최단 경로에 포함되지 않는 에지로만 이동
// 거의 최단거리 찾기, 2개 이상 존재할 수 있다(거리가 같은 경우)
// 0 ~ N - 1번
// 방향 그래프

// 다익스트라에서 continue를 break로 착각 금지!

const int INF = 1e9 + 10;
int dist[501];
int n, m, s, d;

void dijkstra(vector<pair<int, int>> adj[], vector<int> pre[]) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    fill(dist, dist + n, INF);
    dist[s] = 0;
    pq.push({0, s});
    while (!pq.empty()) {
        auto [cw, cv] = pq.top();
        pq.pop();
        if (dist[cv] != cw) continue;
        for (auto [nw, nv] : adj[cv]) {
            if (dist[nv] > dist[cv] + nw) {
                dist[nv] = dist[cv] + nw;
                pq.push({dist[nv], nv});
                pre[nv].clear();
                pre[nv].push_back(cv);
            } else if (dist[nv] == dist[cv] + nw) {
                pre[nv].push_back(cv);
            }
        }
    }
}

void dijkstra_except(vector<pair<int, int>> adj[]) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    fill(dist, dist + n, INF);
    dist[s] = 0;
    pq.push({0, s});
    while (!pq.empty()) {
        auto [cw, cv] = pq.top();
        pq.pop();
        if (dist[cv] != cw) continue;
        for (auto [nw, nv] : adj[cv]) {
            if (dist[nv] <= dist[cv] + nw) continue;
            dist[nv] = dist[cv] + nw;
            pq.push({dist[nv], nv});
        }
    }
}

void remove_shortest_path_edges(vector<pair<int, int>> adj[], vector<int> pre[], int v) {
    queue<int> q;
    vector<bool> visited(n + 1, false);
    q.push(v);
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        if (visited[cur]) continue;
        visited[cur] = true;
        for (int p : pre[cur]) { // p -> cur
            auto it = remove_if(adj[p].begin(), adj[p].end(), [cur](pair<int, int>& edge) {
                return edge.second == cur;
            });
            adj[p].erase(it, adj[p].end());
            q.push(p);
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    while (true) {
        vector<pair<int, int>> adj[501];
        vector<int> pre[501];  // 최단 경로 저장 배열
        cin >> n >> m;
        if (n == 0 && m == 0) break;
        cin >> s >> d;
        while (m--) {
            int u, v, w;
            cin >> u >> v >> w;
            adj[u].push_back({w, v});
        }
        // 최단 경로 찾기
        dijkstra(adj, pre);
        if (dist[d] == INF) {
            cout << -1 << '\n';
            continue;
        }
        int shortest_dist = dist[d];
        // 백트래킹으로 최단 경로 에지 제거하기
        remove_shortest_path_edges(adj, pre, d);

        // 거의 최단 경로 찾기
        dijkstra_except(adj);

        int almost_shortest_dist = dist[d];
        if (almost_shortest_dist == shortest_dist || almost_shortest_dist == INF) {
            cout << -1 << '\n';
        } else {
            cout << almost_shortest_dist << '\n';
        }
    }
}
