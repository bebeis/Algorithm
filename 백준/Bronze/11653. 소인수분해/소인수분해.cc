#include <bits/stdc++.h>
using namespace std;

int n;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;

    for (int i = 2; i * i <= n; i++) {
        while (n % i == 0) {
            cout << i << '\n';
            n /= i;
        }
    }
    if (n != 1) cout << n;
}