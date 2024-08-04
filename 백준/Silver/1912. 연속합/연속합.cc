#include <bits/stdc++.h>
using namespace std;

int s[100001];
int d[100001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> s[i];
    d[1] = s[1];
    for (int i = 2; i <= n; i++) {
        /* 코드 개선
        if (d[i - 1] > 0) d[i] = d[i - 1] + s[i];
        else d[i] = s[i];
        위 코드를 아래로 줄일 수 있다.
        */ 
        d[i] = max(0, d[i - 1]) + s[i];
    }
    cout << *max_element(d + 1, d + n + 1);
}