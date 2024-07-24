#include <bits/stdc++.h>
using namespace std;

struct edge {
    int st;
    int ed;
    int weight;

    bool operator>(const edge& e) const {
        return weight > e.weight;
    }
};

int n, sum = 0;
const int INF = 0x3f3f3f3f;
int dist[21][21];
int ans[21][21];

void floyd() {
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (ans[i][j] > ans[i][k] + ans[k][j]) {
                    ans[i][j] = ans[i][k] + ans[k][j];
                }
            }
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    priority_queue<edge, vector<edge>, greater<edge>> pq;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> dist[i][j];
            pq.push({i, j, dist[i][j]});
        }
    }
    for (int i = 1; i <= n; i++) {
        fill(ans[i], ans[i] + n + 1, INF);
        ans[i][i] = 0;
    }

    while (!pq.empty()) {
        auto [st, ed, weight] = pq.top();
        pq.pop();
        if (ans[st][ed] > weight) {
            ans[st][ed] = ans[ed][st] = weight;
            sum += weight;
            floyd();
        }
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (ans[i][j] == INF || ans[i][j] != dist[i][j]) {
                cout << -1;
                return 0;
            }
        }
    }

    cout << sum;
}