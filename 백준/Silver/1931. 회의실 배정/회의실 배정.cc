#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, count = 0, cur_time = 0;
    cin >> n;
    vector<pair<int, int>> schd(n);
    // O(N)
    for (auto it = schd.begin(); it != schd.end(); it++) {
        cin >> (*it).first >> (*it).second;
    }
    // O(NlogN)
    std::sort(schd.begin(), schd.end(), [](pair<int, int> a, pair<int, int> b) {
        return (a.second == b.second) ? a.first < b.first : a.second < b.second;
    });
    for (auto it = schd.begin(); it != schd.end(); it++) {
        if (cur_time <= (*it).first) {
            cur_time = (*it).second;
            count++;
        }
    }
    cout << count;
}