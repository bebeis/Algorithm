#include <bits/stdc++.h>
using namespace std;


int arr[10];
bool vis[10];
int n, m; // 1~n 중 m개를 고른다

void backtracking(int target) {
    for (int i = 1; i <= n; i++) {
        if (vis[i]) continue;
        arr[target] = i;
        vis[i] = true;
        if (target == m) {
            for (int i = 1; i <= m; i++) cout << arr[i] << " ";
            cout << '\n';
        } else backtracking(target + 1);
        vis[i] = false;
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    backtracking(1);
}