#include <bits/stdc++.h>
using namespace std;

// 점화식 : d[n] = d[n - 1] + d[n - 2]

int d[1001];
int n;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cin >> n;
    d[1] = 1; d[2] = 2;
    for (int i = 3; i <= n; i++) d[i] = (d[i - 1] + d[i - 2]) % 10007;
    cout << d[n];
}