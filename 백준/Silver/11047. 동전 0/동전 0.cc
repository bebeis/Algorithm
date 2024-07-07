#include <bits/stdc++.h>
using namespace std;

// CoinChange Problem에서 동전이 배수 관계--> Greedy로 최적해를 구할 수 있다.

int arr[10];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, k, max_idx = 0, cnt = 0;
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        if (arr[i] <= k) {
            max_idx = i;
        }
    }
    while (k) {
        if (k >= arr[max_idx]) {
            cnt += k / arr[max_idx];
            k = k % arr[max_idx];
        }
        max_idx--;
    }
    cout << cnt;
}