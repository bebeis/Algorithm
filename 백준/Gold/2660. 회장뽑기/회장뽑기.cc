#include <bits/stdc++.h>
using namespace std;

// 몇 사람을 통하면 그룹 내에서 모두 알 수 있다
// 점수 : ASP중 최대
// 친구, (친구, 친구) --> 친구
// 제일 인싸 --> 회장

const int INF = 0x3f3f3f3f;
int dist[51][51];
int score[51];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, a, b, min_score = INT_MAX;
    vector<int> candicate;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        fill(dist[i], dist[i] + n + 1, INF);
        dist[i][i] = 0;
    }
    while (1) {
        cin >> a >> b;
        if (a == -1 && b == -1) break;
        dist[a][b] = dist[b][a] = 1;
    }
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j])
                    dist[i][j] = dist[i][k] + dist[k][j];
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        int max = -1;
        for (int j = 1; j <= n; j++) {
            if (max < dist[i][j]) max = dist[i][j];
        }
        score[i] = max;
        if (min_score > max) {
            min_score = max;
        }
    }

    for (int i = 1; i <= n; i++) {
        if (score[i] == min_score) candicate.push_back(i);
    }

    sort(candicate.begin(), candicate.end());
    cout << min_score << " " << candicate.size() << '\n';
    for (int x : candicate) {
        cout << x << " ";
    }
}