#include <bits/stdc++.h>
using namespace std;

// 음수 가중치 --> 벨만 포드 알고리즘 사용
// 음수 사이클이 존재하는 경우 -1을 출력
// 1번 도시에서 출발

struct edge {
    int st;
    int ed;
    int weight;
};

const int INF = 1e9 + 10;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, m;
    cin >> n >> m;
    vector<edge> edges(m);
    vector<long long> dist(n + 1, INF);
    dist[1] = 0;
    for (int i = 0; i < m; i++) {
        cin >> edges[i].st >> edges[i].ed >> edges[i].weight;
    }
    // 벨만 포드
    for (int i = 0; i < n - 1; i++) {
        for (auto& edge : edges) {
            if (dist[edge.st] == INF) continue;

            if (dist[edge.ed] > dist[edge.st] + edge.weight)
                dist[edge.ed] = dist[edge.st] + edge.weight;
        }
    }
    // 음수 사이클 검사
    for (auto& edge : edges) {
        if (dist[edge.st] == INF) continue;

        if (dist[edge.ed] > dist[edge.st] + edge.weight) {
            cout << -1;
            return 0;
        }
    }

    for (int i = 2; i <= n; i++) {
        cout << ((dist[i] == INF) ? -1 : dist[i]) << '\n';
    }
}