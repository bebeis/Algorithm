#include <bits/stdc++.h>
using namespace std;

// 2
// 1 3 6 6 7 9 
// 2 3 1 2 --> 3을 제외한다
// 범위 : -1000000 ~ 1000000
// 20 3 14 6 7 8 18 10 12 15
// 3 6 7 8 10 12 14 15 18 20
// 3 1 1 2 2 2 1 3 2 --> 큰거 (k - 1)개 지우기

int s[10001];
int d[10001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < n; i++) cin >> s[i];
    if (k >= n) {
        cout << 0;
        return 0;
    }
    sort(s, s + n);
    for (int i = 1; i < n; i++) d[i - 1] = s[i] - s[i - 1];
    sort(d, d + n - 1);
    cout << accumulate(d, d + n - k, 0);
}