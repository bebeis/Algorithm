#include <bits/stdc++.h>
using namespace std;

int n, m;
int input[10];
// bool vis[10];
int arr[10];

void backtracking(int before, int cur) {
    if (cur == m) {
        for (int i = 0; i < m; i++) cout << arr[i] << ' ';
        cout << '\n';
        return;
    }

    for (int i = before + 1; i < n; i++) {
        arr[cur] = input[i];
        backtracking(i, cur + 1);
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> input[i];
    sort(input, input + n);
    backtracking(-1, 0);
}