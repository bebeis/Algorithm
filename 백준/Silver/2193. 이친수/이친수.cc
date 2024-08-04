#include <bits/stdc++.h>
using namespace std;

unsigned long long d[91];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    d[1] = d[2] = 1;
    for (int i = 3; i <= n; i++) d[i] = d[i - 1] + d[i - 2];
    cout << d[n];
}