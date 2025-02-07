#include <bits/stdc++.h>
using namespace std;

int input[15];
int arr[15];
int n;

void backtracking(int before, int cur) {
    if (cur == 6) {
        for (int i = 0; i < 6; i++) cout << arr[i] << ' ';
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

    while (1) {
        cin >> n;
        if (n == 0) break;
        for (int i = 0; i < n; i++) cin >> input[i];
        backtracking(-1, 0);
        cout << '\n';
    }
}