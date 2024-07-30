#include <bits/stdc++.h>
using namespace std;

int arr[500002];
int n;

// 라이브러러 써서 풀기

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int m, t;
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    cin >> m;
    while (m--) {
        cin >> t;
        cout << upper_bound(arr, arr + n, t) - lower_bound(arr, arr + n, t) << ' ';
    }
}