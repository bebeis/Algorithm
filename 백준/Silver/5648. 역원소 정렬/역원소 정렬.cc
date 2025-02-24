#include <bits/stdc++.h>
using namespace std;

unsigned long long arr[1000002];


int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        reverse(s.begin(), s.end());
        arr[i] = stoull(s);
    }
    sort(arr, arr + n);
    for (int i = 0; i < n; i++) cout << arr[i] << '\n';
}