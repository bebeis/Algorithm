#include <bits/stdc++.h>
using namespace std;

int arr[2188][2188];

int result[3];

void partition(int n, int x, int y) {
    if (n == 1) {
        result[arr[x][y] + 1]++;
        return;
    }
    int tmp = arr[x][y];
    bool square = true;
    for (int i = x; i < x + n; i++) {
        for (int j = y; j < y + n; j++) {
            if (tmp != arr[i][j]) {
                square = false;
                break;
            }
        }
    }
    if (square) {
        result[arr[x][y] + 1]++;
    } else {
        partition(n / 3, x, y);
        partition(n / 3, x + n / 3, y);
        partition(n / 3, x + n * 2 / 3, y);
        partition(n / 3, x, y + n / 3);
        partition(n / 3, x + n / 3, y + n / 3);
        partition(n / 3, x + n * 2 / 3, y + n / 3);
        partition(n / 3, x, y + n * 2 / 3);
        partition(n / 3, x + n / 3, y + n * 2 / 3);
        partition(n / 3, x + n * 2 / 3, y + n * 2 / 3);
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }
    partition(n, 0, 0);
    for (int &k : result) {
        cout << k << '\n';
    }
}