#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
int arr[1000002];

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);

    int t; cin >> t;
    while (t-- > 0) {
        int n; cin >> n;
        for (int i = 0; i < n; i++) cin >> arr[i];

        int max = 0;
        ull earn = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) max = arr[i];
            else earn += (max - arr[i]);
        }
        cout << earn << '\n';
    }
}