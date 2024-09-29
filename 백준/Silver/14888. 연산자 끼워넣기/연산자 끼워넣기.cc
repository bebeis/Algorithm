#include <bits/stdc++.h>
using namespace std;

int n; 
int arr[12];
int op[4]; // +, -, *, %
int MAX = -1e9 - 10, MIN = 1e9 + 10;

void backtracking(int pos, int before) {
    if (pos == n) {
        MAX = max(MAX, before);
        MIN = min(MIN, before);
        return;
    }

    for (int i = 0; i < 4; i++) {
        if (!op[i]) continue;
        op[i]--;
        if (i == 0) backtracking(pos + 1, before + arr[pos]);
        else if (i == 1) backtracking(pos + 1, before - arr[pos]);
        else if (i == 2) backtracking(pos + 1, before * arr[pos]);
        else if (i == 3) backtracking(pos + 1, before / arr[pos]);
        op[i]++;
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    for (int i = 0; i < 4; i++) cin >> op[i];
    backtracking(1, arr[0]);
    cout << MAX << '\n' << MIN;
}