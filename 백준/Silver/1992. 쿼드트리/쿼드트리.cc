#include <bits/stdc++.h>
using namespace std;
int arr[64][64];

void partition(int n, int x, int y) {
    if (n == 1) {
        cout << arr[y][x];
        return;
    }
    bool square = true;
    int first = arr[y][x];
    for (int i = y; i < y + n; i++) {
        for (int j = x; j < x + n; j++) {
            if (first != arr[i][j]) {
                square = false;
                break;
            }
        }
    }
    if (square) {
        cout << first;
    } else {
        cout << '(';
        partition(n / 2, x, y);
        partition(n / 2, x + n / 2, y);
        partition(n / 2, x, y + n / 2);
        partition(n / 2, x + n / 2, y + n / 2);
        cout << ')';
    }
}

int main(void) {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%1d", &arr[i][j]);
        }
        cin.get();
    }
    partition(n, 0, 0);
}