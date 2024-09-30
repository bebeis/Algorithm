#include <bits/stdc++.h>
using namespace std;

// 틀린 이유 : 그래프의 모든 노드가 연결되어있다고 가정하고 풀어버림

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int k; cin >> k;
    while (k--) {
        int v, e;
        cin >> v >> e;
        vector<int> adj[20001];
        int visited[20001]; // 0 : 방문 X, 1 : 파랑, 2 : 빨강
        bool isParity = true;
        memset(visited, 0, sizeof(visited));
        while (e--) {
            int st, ed;
            cin >> st >> ed;
            adj[st].push_back(ed);
            adj[ed].push_back(st);
        }

        // 한 정점에서 시작해서 DFS를 돈다.
        // 연결된 정점을 빨간색과 파란색으로 번갈아가면서 칠하는데
        // 만약 이미 칠해진 곳을 방문했을 때 칠해야 할 색깔과 기존 색깔이 다르다면 이분 그래프가 아님
        stack<pair<int, int>> S; // vertex, color
        while (1) {
            bool End = true;
            for (int i = 1; i <= v; i++) {
                if (!visited[i]) {
                    S.push({i, 1});
                    End = false;
                    break;
                }
            }
            if (End) break;
            while (!S.empty()) {
                auto [vertex, color] = S.top();
                S.pop();
                if (visited[vertex]) {
                    if (visited[vertex] != color) {
                        isParity = false;
                        break;
                    }
                } else {
                    visited[vertex] = color;
                    for (auto nxt : adj[vertex]) {
                        if (color == 1) S.push({nxt, 2});
                        else S.push({nxt, 1});
                    }
                }
            }
        }

        if (isParity) cout << "YES\n";
        else cout << "NO\n";
    }
}