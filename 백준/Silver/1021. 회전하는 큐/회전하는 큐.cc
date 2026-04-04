#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(false);
    int n, m, cnt = 0;
    cin >> n >> m;
    deque<int> dq;
    for (int i = 1; i <= n; i++) dq.push_back(i);

    while (m--) {
        int t; cin >> t;
        int pos = find(dq.begin(), dq.end(), t) - dq.begin();
        int sz = dq.size();
        if (pos <= sz - pos) {
            cnt += pos;
            rotate(dq.begin(), dq.begin() + pos, dq.end());
        } else {
            cnt += sz - pos;
            rotate(dq.begin(), dq.end() - (sz - pos), dq.end());
        }
        dq.pop_front();
    }
    cout << cnt;
}