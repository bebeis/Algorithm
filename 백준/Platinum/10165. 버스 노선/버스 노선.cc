#include <bits/stdc++.h>
using namespace std;

// n이 10억 이하 --> 정류소 기준 접근은 MLE, TLE
// 노선 기준으로 접근 --> O(mlogm) 이하로 풀어야 함
pair<int, pair<int, int>> lines[500001];  // (rx, (tx, original_index))
bool incl_lines[500001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= m; i++) {
        int rx, tx;
        cin >> rx >> tx;
        lines[i] = {rx, {tx, i}};  // 원래 인덱스 i를 저장
    }
    sort(lines + 1, lines + m + 1, [](const pair<int, pair<int, int>>& a, const pair<int, pair<int, int>>& b) {
        if (a.first == b.first) {
            bool atypeA = a.first > a.second.first;
            bool btypeA = b.first > b.second.first;
            if (atypeA && btypeA)
                return a.second.first > b.second.first;
            else if (atypeA && !btypeA)
                return a.second.first > b.second.first;
            else if (!atypeA && btypeA)
                return b.second.first > a.second.first;
            else
                return a.second.first > b.second.first;
        }
        return a.first < b.first;  // 기본적으로 rx가 작은 순으로
    });
    int j = 1;
    for (int i = 2; i <= m; i++) {
        bool A = lines[j].first > lines[j].second.first;
        bool B = lines[i].first > lines[i].second.first;
        bool C = lines[i].first >= lines[j].first;
        bool D = lines[i].second.first <= lines[j].second.first;
        if ((A && B && C && D) ||
            (A && !B && C) ||
            (A && !B && D) ||
            (!A && !B && C && D)) {
            incl_lines[lines[i].second.second] = true;  // 원래 인덱스를 사용
        } else {
            j = i;
        }
    }
    int i = 1;
    if (i != j) {
        bool A = lines[j].first > lines[j].second.first;
        bool B = lines[i].first > lines[i].second.first;
        bool C = lines[i].first >= lines[j].first;
        bool D = lines[i].second.first <= lines[j].second.first;
        if ((A && B && C && D) ||
            (A && !B && C) ||
            (A && !B && D) ||
            (!A && !B && C && D)) {
            incl_lines[lines[i].second.second] = true;  // 원래 인덱스를 사용
        }
    }

    for (int i = 1; i <= m; i++) {
        if (!incl_lines[i]) cout << i << " ";
    }
}