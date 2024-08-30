#include <bits/stdc++.h>
using namespace std;

// 항상 문제를 모두 풀 수 있는 경우만 입력으로 주어짐
// ax 와 ay간의 순서쌍 여러개가 주어짐 --> 위상정렬
// 위상정렬에서 queue를 사용하는 대신 pq를 사용하면 된다

int n, m;
vector<int> adj[32001];
int indeg[32001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    while (m--) {
        int v, e;
        cin >> v >> e;
        adj[v].push_back(e);
        indeg[e]++;
    }

    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 1; i <= n; i++) if (indeg[i] == 0) pq.push(i);

    while (!pq.empty()) {
        int cur = pq.top(); pq.pop();
        cout << cur << ' ';

        for (int nxt : adj[cur]) {
            if (--indeg[nxt] == 0) pq.push(nxt);
        }
    }
}