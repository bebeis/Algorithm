#include <bits/stdc++.h>
using namespace std;

int arr[1000002];

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    int n, s; cin >> n >> s;
    for (int i = 0; i < n; i++) cin >> arr[i];

    int cnt = 0;
    for (int i = 1; i < (1 << n); i++) {
        int sum = 0;

        int mask = i;
        while (mask) {
            int pos = __builtin_ctz(mask);
            sum += arr[pos];
            mask &= mask - 1;
        }

        if (sum == s) cnt++;
    }

    cout << cnt;
}