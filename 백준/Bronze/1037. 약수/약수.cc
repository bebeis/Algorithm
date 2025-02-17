#include <bits/stdc++.h>
using namespace std;

int arr[52];
int n;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];

    sort(arr, arr + n);
    if (n == 1) cout << arr[0] * arr[0];
    else cout << arr[0] * arr[n - 1];

}