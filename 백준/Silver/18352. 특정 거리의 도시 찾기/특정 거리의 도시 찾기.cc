#include <bits/stdc++.h>
using namespace std;

// 출발점이 주어짐 --> SSP 문제 --> 다익스트라
// 가중치가 모두 1이므로 BFS로 푸는게 빠를듯
vector<int> adj[300001];
int d[300001];
bool vis[300001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, k, x;
    vector<int> output;
    queue<int> Q;
    cin >> n >> m >> k >> x;
    while (m--) {
        int s, e;
        cin >> s >> e;
        adj[s].push_back(e);
    }
    d[x] = 0;
    vis[x] = 1;
    Q.push(x);
    while (!Q.empty()) {
        int cur = Q.front();
        Q.pop();
        for (int nx : adj[cur]) {
            if (vis[nx]) continue;
            d[nx] = d[cur] + 1;
            if (d[nx] == k) output.push_back(nx);
            vis[nx] = 1;
            Q.push(nx);
        }
    }
    if (output.empty()) {
        cout << -1;
    } else {
        sort(output.begin(), output.end());
        for (int a : output) {
            cout << a << '\n';
        }
    }
} 