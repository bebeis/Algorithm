#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;

ull d[93][2];

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    ull n; cin >> n;

    d[1][1] = 1;
    d[1][0] = 0;

    for (int i = 2; i <= n; i++) {
        d[i][1] = d[i - 1][0];
        d[i][0] = d[i - 1][1] + d[i - 1][0];
    }

    cout << d[n][1] + d[n][0];
}