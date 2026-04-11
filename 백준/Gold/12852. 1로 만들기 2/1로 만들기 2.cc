#include <bits/stdc++.h>
using namespace std;

int bef[1000002];
int d[1000002];

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    int n; cin >> n;

    d[1] = 0;
    for (int i = 2; i <= n; i++) {
        d[i] = d[i - 1] + 1;
        bef[i] = i - 1;
        if (i % 2 == 0) {
            int tmp = d[i / 2] + 1;
            if (tmp < d[i]) {
                d[i] = tmp;
                bef[i] = i / 2;
            }
        }
        if (i % 3 == 0) {
            int tmp = d[i / 3] + 1;
            if (tmp < d[i]) {
                d[i] = tmp;
                bef[i] = i / 3;
            }
        } 
    }

    cout << d[n] << '\n';

    int st = n;
    while (st != 1) {
        cout << st << ' ';
        st = bef[st];
    }
    cout << 1;
}