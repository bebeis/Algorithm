#include <bits/stdc++.h>
using namespace std;

int n, m;
const int INF = 0x3f3f3f3f;
int result = 0;
vector<int> adj[501];
bool visited[501][501];

void DFS(int start, int cur) {
    for (auto nxt : adj[cur]) {
        if (visited[start][nxt] == false) {
            visited[start][nxt] = true;
            DFS(start, nxt);
        }
    }
}

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);

    cin >> n >> m;

    while (m--) {
        int a, b; // height(a) < height(b)
        cin >> a >> b;
        adj[a].push_back(b);
    }

    for (int i = 1; i <= n; i++) visited[i][i] = true;

    for (int i = 1; i <= n; i++) DFS(i, i);

    for (int i = 1; i <= n; i++) {
        bool isLinked = true;
        for (int j = 1; j <= n; j++) {
            if (!visited[i][j] && !visited[j][i]) {
                isLinked = false;
                break;
            }
        }
        if (isLinked) result++;
    }

    cout << result;
}