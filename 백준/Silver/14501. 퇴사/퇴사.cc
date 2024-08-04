#include <bits/stdc++.h>
using namespace std;

int t[16];
int p[16];
int d[21];

// 상담 전 자산 + 상담 비용 > 기존 : 갱신

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> t[i] >> p[i];
    for (int i = 1; i <= n; i++) {
        if (d[i + 1] < d[i]) d[i + 1] = d[i];

        int nxt = i + t[i];
        d[nxt] = max(d[nxt], d[i] + p[i]);
    }
    cout << d[n + 1];
}