#include <bits/stdc++.h>
using namespace std;

// tabulation 풀이
// 처음에 테이블을 완성해둔 후 TC마다 출력해주면 된다
int d[11];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    d[1] = 1; d[2] = 2; d[3] = 4;
    for (int i = 4; i < 11; i++) {
        d[i] = d[i - 1] + d[i - 2] + d[i - 3];
    }
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << d[n] << '\n';
    }
}