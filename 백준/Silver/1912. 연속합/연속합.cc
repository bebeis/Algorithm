#include <bits/stdc++.h>
using namespace std;

int d[100002];
int arr[100002];
int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    int n; cin >> n;

    for (int i = 1; i <= n; i++) cin >> arr[i];

    for (int i = 1; i <= n; i++) {
        d[i] = max(d[i - 1] + arr[i], arr[i]);
    }

    cout << *max_element(d + 1, d + n + 1);
}