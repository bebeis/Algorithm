#include <bits/stdc++.h>
using namespace std;

pair<int, int> times[100002];

int main() {
    cin.tie(0) -> sync_with_stdio(false);
    int n; cin >> n;
    
    for (int i = 0; i < n; i++) {
        int st, ed; cin >> st >> ed;
        times[i] = {st, ed};
    }

    sort(times, times + n, [](const auto& p1, const auto& p2) {
        if (p1.second != p2.second) return p1.second < p2.second;
        return p1.first < p2.first;
    }); 

    int last = 0;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (times[i].first < last) continue;
        last = times[i].second;
        cnt++;
    }
    cout << cnt;
}