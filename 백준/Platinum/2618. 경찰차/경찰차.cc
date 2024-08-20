#include <bits/stdc++.h>
using namespace std;

// i 부터 j까지의 거리를 기록해두면 되지 않을까?

int n, w;
pair<int, int> pos[1001];
pair<int, int> pre[1001][1001];
bool vis[1001][1001];
int dist[1001][1001];

inline int getDistance(const pair<int, int>& lhs, const pair<int, int>& rhs) {
    return abs(lhs.first - rhs.first) + abs(lhs.second - rhs.second);
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> w;
    for (int i = 1; i <= w; i++) cin >> pos[i].first >> pos[i].second;
    dist[0][0] = 1e9+10;
    // 기저 조건
    dist[0][1] = getDistance({n, n}, pos[1]);
    for (int i = 2; i <= w; i++) {
        dist[0][i] = dist[0][i - 1] + getDistance(pos[i - 1], pos[i]);
        pre[0][i] = {0, i - 1};
    }
    dist[1][0] = getDistance({1, 1}, pos[1]);
    for (int i = 2; i <= w; i++) {
        dist[i][0] = dist[i - 1][0] + getDistance(pos[i - 1], pos[i]);
        pre[i][0] = {i - 1, 0};
    }

    // 점화식
    for (int k = 1; k <= w; k++) {
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                if (vis[i][j]) continue;
                vis[i][j] = 1;
                int MinDist = 1e9 + 10;
                if (i == j) dist[i][j] = MinDist; 
                else if (i > j) {
                    if (i - j == 1) {
                        for (int p = i - 2; p > 0; p--) {
                            if (MinDist > dist[p][j] + getDistance(pos[i], pos[p])) {
                                MinDist = dist[p][j] + getDistance(pos[i], pos[p]);
                                pre[i][j] = {p, j};
                            }
                        }
                        if (MinDist > dist[0][j] + getDistance(pos[i], {1, 1})) {
                            MinDist = dist[0][j] + getDistance(pos[i], {1, 1});
                            pre[i][j] = {0, j};
                        }
                        dist[i][j] = MinDist;
                    } else {
                        dist[i][j] = dist[i - 1][j] + getDistance(pos[i], pos[i - 1]);
                        pre[i][j] = {i - 1, j};
                    }
                } else {
                    if (j - i == 1) {
                        for (int p = j - 2; p > 0; p--) {
                            if (MinDist > dist[i][p] + getDistance(pos[j], pos[p])) {
                                MinDist = dist[i][p] + getDistance(pos[j], pos[p]);
                                pre[i][j] = {i, p};
                            }
                        }
                        if (MinDist > dist[i][0] + getDistance(pos[j], {n, n})) {
                            MinDist = dist[i][0] + getDistance(pos[j], {n, n});
                            pre[i][j] = {i, 0};
                        }
                        dist[i][j] = MinDist;
                    } else {
                        dist[i][j] = dist[i][j - 1] + getDistance(pos[j], pos[j - 1]);
                        pre[i][j] = {i, j - 1};
                    }
                }
            }
        }
    }
    int result = 1e9+10;
    pair<int, int> dest;
    for (int i = 0; i <= w; i++) {
        if (result > dist[i][w]) {
            result = dist[i][w];
            dest = {i, w};
        }
        if (result > dist[w][i]) {
            result = dist[w][i];
            dest = {w, i};
        }
    }

    // for (int i = 0; i <= w; i++) {
    //     for (int j = 0; j <= w; j++) {
    //         cout << dist[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }

    vector<int> output;
    while (dest.first != 0 || dest.second != 0) {
        if (dest.first == w) output.push_back(1);
        else output.push_back(2);
        
        w--;
        dest = pre[dest.first][dest.second];
    }

    cout << result << '\n';
    for (auto rit = output.rbegin(); rit != output.rend(); rit++) {
        cout << *rit << '\n';
    }

}