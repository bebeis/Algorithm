#include <bits/stdc++.h>
using namespace std;

int a[3][100002];
int d[4][100002];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int t; cin >> t;
    while (t--) {
        int n; cin >> n;
        for (int j = 1; j <= n; j++) cin >> a[1][j];
        for (int j = 1; j <= n; j++) cin >> a[2][j];
        d[1][1] = a[1][1]; d[2][1] = a[2][1];
        for (int i = 2; i <= n; i++) {
            int tmp = max({d[1][i - 2], d[2][i - 2], d[3][i - 2]});
            d[2][i] = max(d[1][i - 1], tmp) + a[2][i];
            d[1][i] = max(d[2][i - 1], tmp) + a[1][i];
            d[3][i] = tmp + max(a[1][i], a[2][i]);
        }
        cout << max({d[1][n], d[2][n], d[3][n]}) << '\n';
    }
}