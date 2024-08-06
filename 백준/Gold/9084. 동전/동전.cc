#include <bits/stdc++.h>
using namespace std;

// 1 ~ 10,000 (금액)
// 동전의 개수 <= 20
// n * m * t <= 2,000,000
// TC <= 10
// ax1 + bx2 + cx3 + ... = m을 만족하는 (x1, x2, x3... 의 수)

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n; 
        vector<int> arr(n);
        for (int i = 0; i < n; ++i) cin >> arr[i];
        cin >> m;
        vector<int> d(m + 1, 0);
        d[0] = 1;
        // o(nm)
        for (auto val : arr) {
            for (int i = val; i <= m; i++) {
                d[i] += d[i - val];
            }
        }
        cout << d[m] << '\n';
    }
}
