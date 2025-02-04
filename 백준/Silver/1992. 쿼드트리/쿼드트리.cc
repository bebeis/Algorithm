#include <bits/stdc++.h>
using namespace std;

int n;
char board[66][66];

void partition(int cx, int cy, int length) {
    char first = board[cx][cy];
    for (int i = cx; i < cx + length; i++) {
        for (int j = cy; j < cy + length; j++) {
            if (board[i][j] != first) {
                int halfLength = length / 2;
                cout << '(';
                partition(cx, cy, halfLength);
                partition(cx, cy + halfLength, halfLength);
                partition(cx + halfLength, cy, halfLength);
                partition(cx + halfLength, cy + halfLength, halfLength);
                cout << ')';
                return;
            }
        }
    }
    cout << first;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) cin >> board[i][j];
    }
    partition(0, 0, n);
}