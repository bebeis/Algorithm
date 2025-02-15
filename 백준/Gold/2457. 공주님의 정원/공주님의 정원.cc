#include <bits/stdc++.h>
using namespace std;

int n, cnt = 0;
pair<pair<int, int>, pair<int, int>> flower[100001];
// DP로 풀려고 하니 O(N^2)이 시간 초과 -> 그리디가 가능한지 체크

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> flower[i].first.first >> flower[i].first.second >> flower[i].second.first >> flower[i].second.second;
    }

    sort(flower, flower + n, [](pair<pair<int, int>, pair<int, int>> f1, pair<pair<int, int>, pair<int, int>> f2) {
        return f1.first < f2.first;
    });

    // for (int i = 0; i < n; i++) {
    //     cout << flower[i].first.first << ' ' << flower[i].first.second << ' ' << flower[i].second.first << ' ' << flower[i].second.second << '\n';
    // }

    pair<int, int> baseline = {3, 1};
    pair<int, int> endline = {11, 30};
    int pastIdx = 0;
    while (baseline <= endline) {
        int curIdx = -1;
        pair<int, int> maxEndline = baseline;
        for (int i = pastIdx; i < n; i++) {
            if (flower[i].first <= baseline) {
                curIdx = i;
                maxEndline = max(maxEndline, flower[i].second);
            }
            else break;
        }
        if (curIdx == -1) {
            cout << 0;
            return 0;
        }
        baseline = maxEndline;
        pastIdx = curIdx + 1;
        cnt++;
    }

    cout << cnt;
}