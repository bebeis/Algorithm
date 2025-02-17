#include <bits/stdc++.h>
using namespace std;

int m, n;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> m >> n;
    vector<bool> state(n + 1, true);
    state[1] = false;
    for (int i = 2; i * i <= n; i++) {
        if (state[i] == false) continue;
        for (int j = i * i; j <= n; j += i) {
            if (state[j] == true) state[j] = false;
        }
    }
    for (int i = m; i <= n; i++) {
        if (state[i]) cout << i << '\n';
    }
}