#include <bits/stdc++.h>
using namespace std;

// 첫 번째 차원은 자리수, 두 번째 차원은 해당 자리수 1~9에 대한 case 수
int d[101][10];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    for (int i = 1; i <= 9; i++) d[1][i] = 1;
    int n;
    cin >> n;
    for (int i = 2; i <= n; i++) {
        d[i][0] = d[i - 1][1];
        d[i][9] = d[i - 1][8];
        for (int j = 1; j <= 8; j++) {
            d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000;
        }
    }
    cout << accumulate(d[n], d[n] + 10, 0LL) % 1000000000;
}