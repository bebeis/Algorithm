#include <bits/stdc++.h>
using namespace std;

// 무작정 가장 가까운 제곱수 케이스가 최소가 되지는 않는다 --> 요기서 처음에 논리가 틀림
// 4^2 + 5^2 = 41 --> 6^2 + 2^2 + 1이면 틀린다
// d[n] = 어떤 제곱 수 + d[n - 제곱수]

int d[100001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n; cin >> n;
    d[1] = 1;
    for (int i = 2; i <= n; i++) {
        d[i] = i;
        for (int j = 1; j * j <= i; j++) {
            d[i] = min(d[i], 1 + d[i - j * j]);
        }
    }
    cout << d[n];
}