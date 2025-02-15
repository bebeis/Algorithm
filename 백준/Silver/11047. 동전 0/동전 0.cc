#include <bits/stdc++.h>
using namespace std;

int n, k, cnt = 0;
int coin[12];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n >> k;
    int max_idx = 0;
    for (int i = 0; i < n; i++) {
        cin >> coin[i];
        if (coin[i] <= k) max_idx = i;
    }

    
    while (k > 0) {
        cnt += k / coin[max_idx];
        k %= coin[max_idx];
        max_idx--;
    }
    cout << cnt;
}