#include <bits/stdc++.h>
using namespace std;

int n, m;

bool used[10];
int arr[10];

void bt(int curLength) {
    if (curLength == m) {
        for (int i = 0; i < m; i++) {
            cout << arr[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = 1; i <= n; i++) {
        if (used[i]) continue;

        used[i] = true;
        arr[curLength] = i;
        bt(curLength + 1);
        used[i] = false;
    }
}

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    cin >> n >> m;
    bt(0);
}