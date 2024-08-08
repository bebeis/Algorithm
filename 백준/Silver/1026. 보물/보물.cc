#include <bits/stdc++.h>
using namespace std;

int a[51];
int b[51];

// 최적 부분 구조 : 가장 큰수를 가장 작은수와 곱해준다

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, sum = 0; 
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < n; i++) cin >> b[i];
    sort(a, a + n);
    sort(b, b + n, greater<int>());
    for (int i = 0; i < n; i++) sum += a[i] * b[i];
    cout << sum;
}