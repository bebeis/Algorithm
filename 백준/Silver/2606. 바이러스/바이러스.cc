#include <bits/stdc++.h>
using namespace std;

// DFS로 풀이
const int MAX = 101;
bool vis[MAX];
// 인접 리스트 사용
vector<int> adj[MAX];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int n, m, count = 0;
    stack<int> S;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int s, e;
        cin >> s >> e;
        adj[s].push_back(e);
        adj[e].push_back(s);
    }

    // 1번 컴퓨터가 시작점
    vis[1] = true;
    S.push(1);
    while (!S.empty()) {
        int cur = S.top();
        S.pop();
        count++;
        for (int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur][i];
            if (!vis[next]) {
                vis[next] = 1;
                S.push(next);
            }
        }
    }
    // 1번 컴퓨터는 제외해야 하므로 1 빼줌
    cout << count - 1;
}