#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, m;
    cin >> n >> m;
    vector<int> arr(n);
    for (int i = 0; i < n; ++i) cin >> arr[i];
    vector<int> d(m + 1, -1);
    d[0] = 0;
    // o(nm)
    for (int i = 1; i <= m; ++i) {
        for (auto val : arr) {
            if (i >= val) {
                if (d[i - val] == -1) continue;
                else if (d[i] == -1) d[i] = 1 + d[i - val];
                else d[i] = min(d[i], 1 + d[i - val]);
            }
        }
    }
    cout << d[m];
}