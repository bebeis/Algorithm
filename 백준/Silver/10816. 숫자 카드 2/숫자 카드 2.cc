#include <bits/stdc++.h>
using namespace std;

int n;
int arr[500002];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    int m; cin >> m;
    while (m--) {
        int target; cin >> target;
        cout << upper_bound(arr, arr + n, target) - lower_bound(arr, arr + n, target) << ' ';
    }
}