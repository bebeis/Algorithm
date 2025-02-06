#include <bits/stdc++.h>
using namespace std;

int arr[10];
int n, m;

int main(void) {
    cin >> n >> m;

    for (int i = 0; i < m; i++) arr[i] = 0;
    for (int i = m; i < n; i++) arr[i] = 1;
    do {
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) cout << i + 1 << ' ';
        }
        cout << '\n';
    } while (next_permutation(arr, arr + n));
}