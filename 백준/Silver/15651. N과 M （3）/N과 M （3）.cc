#include <bits/stdc++.h>
using namespace std;

// 중복순열

int n, m;
int arr[9];

void permuRepeat(int target) {
    if (target > m) {
        for (int i = 1; i <= m; i++) cout << arr[i] << " ";
        cout << '\n';
        return;
    }
    for (int i = 1; i <= n; i++) {
        arr[target] = i;
        permuRepeat(target + 1);
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    permuRepeat(1);
}