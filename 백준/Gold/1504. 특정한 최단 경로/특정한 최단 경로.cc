#include <bits/stdc++.h>
using namespace std;

// !!!무방향 그래프!!!
// 특정한 최단 경로 --> SSP문제 --> 다익스트라
// 주어진 두 정점은 반드시 거쳐야 한다
// 1 -> cp1 -> cp2 -> N;
// 1 -> cp2 -> cp1 -> N;
// 이동했던 간선을 다시 이용할 수 있다.
// 두 정점 사이 간선은 최대 1개

vector<pair<int, int>> adj[801];
int dist[801];
const int INF = 1e9+10;
int n, e, cp1, cp2;

int dijkstra(int start, int end, int pre) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    fill(dist, dist + n + 1, INF);
    dist[start] = pre;
    pq.push({dist[start], start});
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
    return dist[end];
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cin >> n >> e;
    while (e--) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({w, v});
        adj[v].push_back({w, u});
    }
    cin >> cp1 >> cp2;
    dist[1] = 0;
    // case 1
    int pre = dijkstra(1, cp1, 0);
    pre = dijkstra(cp1, cp2, pre);
    int r1 = dijkstra(cp2, n, pre);
    fill(dist, dist + n + 1, INF);

    // case 2
    pre = dijkstra(1, cp2, 0);
    pre = dijkstra(cp2, cp1, pre);
    int r2 = dijkstra(cp1, n, pre);
    int min = std::min(r1, r2);
    cout << ((min == INF) ? -1 : min);
}