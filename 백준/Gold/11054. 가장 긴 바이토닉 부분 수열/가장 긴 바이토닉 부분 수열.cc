#include <bits/stdc++.h>
using namespace std;

// O(n^2) 이하로 풀이
// d[i] = max(d[i - 1], i번째를 택했을 때 최대 바이토닉 수열의 길이)
// i번째가 바이토닉 수열 내에서 증가하고 있을 수 있고, 감소하고 있을 수 있다.
int a[1001];
int d[1001][2]; // 0 : 증가하는 케이스, 1 : 감소하는 케이스

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];
    d[1][0] = d[n][1] = 1;
    // i번째까지 증가하는 수열 길이
    for (int i = 2; i <= n; i++) {
        for (int j = i - 1; j >= 1; j--) {
            if (a[j] < a[i]) d[i][0] = max(d[i][0], d[j][0]);
        }
        d[i][0]++;
    }
    // 뒤에서 부터 증가한다 == 감소한다
    // i번째 부터 감소할 때 감소 수열의 최대 길이
    for (int i = n - 1; i >= 1; i--) {
        for (int j = i + 1; j <= n; j++) {
            if (a[j] < a[i]) d[i][1] = max(d[i][1], d[j][1]);
        }
        d[i][1]++;
    }
    int max = 0;
    for (int i = 1; i <= n; i++) {
        if (max < d[i][0] + d[i][1]) max = d[i][0] + d[i][1];
    }
    cout << max - 1;
}