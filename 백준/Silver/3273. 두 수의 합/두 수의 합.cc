#include <bits/stdc++.h>
using namespace std;

int arr[100001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    
    int n, x, sum, start = 0, cnt = 0;
    cin >> n;
    int end = n - 1;
    
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    cin >> x;
    
    while (start < end) {
        sum = arr[start] + arr[end];
        if (sum > x) {
            end--;
        } else if (sum < x) {
            start++;
        } else {
            cnt++;
            end--;
            start++;
        }
    }
    cout << cnt;
}
