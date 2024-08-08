#include <bits/stdc++.h>
using namespace std;

// O(n^3/2) 이하로 풀어야 함

int arr[100002];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n; cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    int sum = accumulate(arr, arr + n, 0);
    sort(arr, arr + n);
    int result = 0;
    for (int i = 0; i < n; i++) result = max(result, arr[i] * (n - i));
    cout << result;
}