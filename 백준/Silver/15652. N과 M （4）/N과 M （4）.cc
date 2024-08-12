#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[10];

void combRepeat(int target, int start) {
    // 기저 조건
    if (target > m) {
        for (int i = 1; i <= m; i++) cout << arr[i] << " ";
        cout << '\n';
        return;
    }
    for (int i = start; i <= n; i++) {
        arr[target] = i;
        combRepeat(target + 1, i);
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    combRepeat(1, 1);
}