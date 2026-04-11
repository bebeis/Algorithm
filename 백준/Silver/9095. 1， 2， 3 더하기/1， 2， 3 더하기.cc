/**
 * 4를 구성하는 방법
 * 1에서 4로 점프, 2에서 4로 점프, 3에서 4로 점프
 */

#include <bits/stdc++.h>
using namespace std;

int d[14];

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    d[1] = 1;
    d[2] = 2;
    d[3] = 4;
    for (int i = 4; i <= 10; i++) {
        d[i] = d[i - 1] + d[i - 2] + d[i - 3];
    }

    int t; cin >> t;
    while (t-- > 0) {
        int n; cin >> n;

        cout << d[n] << '\n';
    }
}