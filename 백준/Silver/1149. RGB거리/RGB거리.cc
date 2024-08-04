#include <bits/stdc++.h>
using namespace std;

int c[1001][3]; // 0: R, 1: G, 2: B
int d[1001][3];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n; cin >> n;
    for (int i = 1; i <= n; i++) cin >> c[i][0] >> c[i][1] >> c[i][2];
    d[1][0] = c[1][0]; d[1][1] = c[1][1]; d[1][2] = c[1][2];
    for (int i = 2; i <= n; i++) {
        d[i][0] = min(d[i - 1][1], d[i - 1][2]) + c[i][0];
        d[i][1] = min(d[i - 1][2], d[i - 1][0]) + c[i][1];
        d[i][2] = min(d[i - 1][0], d[i - 1][1]) + c[i][2];
    }
    cout << *min_element(d[n], d[n] + 3);
}