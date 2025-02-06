#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[10];

void backtracking(int cur) {
    if (cur == m) {
        for (int i = 0; i < m; i++) cout << arr[i] << ' ';
        cout << '\n';
        return;
    }

    for (int i = 1; i <= n; i++) {
        arr[cur] = i;
        backtracking(cur + 1);
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;

    backtracking(0);
}