#include <bits/stdc++.h>
using namespace std;

int n, m;
int input[10];
bool vis[10];
int arr[10];

void backtracking(int cur) {
    if (cur == m) {
        for (int i = 0; i < m; i++) cout << arr[i] << ' ';
        cout << '\n';
        return;
    }
    int last = -1;

    for (int i = 0; i < n; i++) {
        if (vis[i]) continue;
        if (input[i] == last) continue;
        arr[cur] = input[i];
        vis[i] = true;
        last = input[i];
        backtracking(cur + 1);
        vis[i] = false;
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> input[i];
    sort(input, input + n);
    backtracking(0);
}