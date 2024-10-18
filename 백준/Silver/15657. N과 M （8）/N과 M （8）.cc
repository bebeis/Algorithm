#include <bits/stdc++.h>
using namespace std;

int n, m; // n, m은 8 이하

int arr[9];
int d[9];

void backtracking(int move) {
    if (move > m) {
        for (int i = 1; i <= m; i++) {
            cout << d[i] << " ";
        }
        cout << '\n';
        return;
    }

    for (int i = 1; i <= n; i++) {
        if (d[move - 1] <= arr[i]) {
            d[move] = arr[i];
            backtracking(move + 1);
        }
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> arr[i];
    sort(arr + 1, arr + n + 1);
    backtracking(1);
}