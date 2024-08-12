#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[10];
bool visited[10];

void comb(int target, int start) {
    // 기저 조건
    if (target > m) {
        for (int i = 1; i <= m; i++) cout << arr[i] << " ";
        cout << '\n';
        return;
    }
    for (int i = start; i <= n; i++) {
        if (visited[i]) continue;
        arr[target] = i;
        visited[i] = 1;
        comb(target + 1, i + 1);
        visited[i] = 0;
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    comb(1, 1);
}