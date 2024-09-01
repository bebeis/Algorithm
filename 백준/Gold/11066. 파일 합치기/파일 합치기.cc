#include <bits/stdc++.h>
using namespace std;

// 테이블 만들기
// 어떻게 합치든 K - 1번을 합쳐야 하고, i번째에 어떤 것을 합치냐에 따라서 결과가 달라진다.
// d[i][j]를 i번째 부터 j번째 까지 합쳤을 때 최소비용으로 세워보자
// d[i][j] = min(d[i][j - 1] * 2 + d[j], d[i + 1][j] * 2 + d[i])이라고 처음에 생각했는데
// d[1][4] = 1~3 + 4 |  1 + 2~4 도 있지만, 1~2 + 3~4도 있다.
// --> 3중 for문을 돌려보자
// bottom - up으로 푼다면, j - i = n(n = 1, 2, .. k - 1) 순서로 순회

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int t; cin >> t;
    while (t--) {
        int k; cin >> k;
        vector<int> arr(k + 1);
        vector<vector<int>> d(k + 1, vector<int>(k + 1, 0));
        vector<int> sum(k + 1, 0);
        
        for (int i = 1; i <= k; i++) {
            cin >> arr[i];
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int n = 1; n <= k - 1; n++) {
            for (int i = 1; i <= k - n; i++) {
                int j = i + n;
                d[i][j] = INT_MAX;
                // i ~ j : i ~ p | p + 1 ~ j
                for (int p = i; p <= j - 1; p++) {
                    d[i][j] = min(d[i][p] + d[p + 1][j] + sum[j] - sum[i - 1], d[i][j]);
                }
            }
        }
        cout << d[1][k] << '\n';
    }
}