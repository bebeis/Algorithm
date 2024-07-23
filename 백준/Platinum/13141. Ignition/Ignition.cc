#include <bits/stdc++.h>
using namespace std;

// 메모리 제한 64MB --> 대입 여러번 하면 MLE 터질듯
// 주의. 양 끝점에 불이 붙으면 중앙까지 태운다

struct edge {
    int st;
    int ed;
    int weight;
};

const int INF = 0x3f3f3f3f;
int dist[201][201];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cout << fixed;
    cout.precision(1);
    int n, m, u, v, w;
    float min_time = numeric_limits<float>::max();
    cin >> n >> m;
    // dist 배열 초기화
    for (int i = 1; i <= n; i++) {
        fill(dist[i], dist[i] + n + 1, INF);
        dist[i][i] = 0;
    }
    vector<edge> edges(m); // 에지 리스트
    for (int i = 0; i < m; i++) {
        cin >> u >> v >> w;
        edges[i] = {u, v, w};
        if (dist[u][v] > w) dist[v][u] = dist[u][v] = w;
    }
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    // 각 노드에서 가장 늦게 타는 시간을 구해서 최소 시간을 찾기
    for (int i = 1; i <= n; i++) {
        float max_time = -1.0;
        for (const auto& e : edges) {
            int st = min(dist[i][e.st], dist[i][e.ed]);
            int ed = max(dist[i][e.st], dist[i][e.ed]);
            float time;
            if ((ed - st) >= e.weight) {
                time = st + e.weight;
            } else {
                time = (st + ed + e.weight) / 2.0;
            }
            if (max_time < time) max_time = time;
        }
        
        if (min_time > max_time) min_time = max_time;
    }
    cout << min_time << "\n";
}
