#include <bits/stdc++.h>
using namespace std;

// 음수 사이클이 존재하는지 판별하는 문제로 보임
// 벨만 포드 알고리즘 사용
// 두 지점을 연결하는 도로가 한 개 이상일 수 있음에 주의!
// 에지는 무방향, 웜홀은 방향이다
// 시작지점이 1~N

const int INF = 1e9 + 10;

struct edge {
    int st;
    int ed;
    int weight;
};

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--) {
        int n, m, w, u, v, c;
        cin >> n >> m >> w;
        vector<edge> edges(2 * m + w);
        vector<long long> dist(n + 1, INF);
        for (int i = 0; i < 2 * m; i += 2) {
            cin >> u >> v >> c;
            edges[i] = {u, v, c};
            edges[i + 1] = {v, u, c};
        }
        // 웜홀
        for (int i = 2 * m; i < 2 * m + w; i++) {
            cin >> u >> v >> c;
            edges[i] = {u, v, -c};
        }
        dist[1] = 0;
        for (int i = 1; i < n; i++) {
            for (auto& edge : edges) {
                // if (dist[edge.st] == INF) continue;
                // 이렇게 해주면 출발점과 상관 없이 음수 사이클을 체크할 수 있다.

                if (dist[edge.ed] > dist[edge.st] + edge.weight)
                    dist[edge.ed] = dist[edge.st] + edge.weight;
            }
        }
        bool check = false;
        // 음수 가중치 사이클 체크
        for (auto& edge : edges) {
            if (dist[edge.ed] > dist[edge.st] + edge.weight) {
                cout << "YES\n";
                check = true;
                break;
            }
        }
        if (check) continue;
        cout << "NO\n";
    }
}