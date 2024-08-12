#include <bits/stdc++.h>
using namespace std;

int n, m;
int input[9];
int arr[9];
bool vis[10001];


void func(int target) {
    if (target == m) {
        for (int i = 0; i < m; i++) cout << arr[i] << " ";
        cout << '\n';
        return;
    }
    for (int i = 0; i < n; i++) {
        if (vis[input[i]] == true) continue;
        arr[target] = input[i];
        vis[input[i]] = true;
        func(target + 1);
        vis[input[i]] = false;
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> input[i];
    sort(input, input + n);
    func(0);
}