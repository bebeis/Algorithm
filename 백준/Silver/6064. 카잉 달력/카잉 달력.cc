#include <bits/stdc++.h>
using namespace std;

// i % m == x // mk + x
// i % n == y // nl + y

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int t; cin >> t;
    while (t--) {
        int m, n, x, y; cin >> m >> n >> x >> y;
        x--; y--;
        bool valid = false;
        for (int i = x; i <= m * n; i += m) {
            if (i % n == y) {
                cout << i + 1 << '\n';
                valid = true;
                break;
            }
        }
        if (!valid) cout << "-1\n";
    }
}