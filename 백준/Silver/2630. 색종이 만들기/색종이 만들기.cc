#include <bits/stdc++.h>
using namespace std;
int white = 0;
int blue = 0;
int colorPaper[128][128];

void partition(int n, int x, int y) {
    if (n == 1) {
        (colorPaper[y][x] == 1) ? blue++ : white++;
        return;
    }
    bool square = true;
    for (int i = y; i < y + n; i++) {
        for (int j = x; j < x + n; j++) {
            if (colorPaper[i][j] != colorPaper[y][x]) {
                square = false;
                break;
            }
        }
    }
    if (square == true) {
        (colorPaper[y][x] == 1) ? blue++ : white++;
    }
    else {
        partition(n / 2, x, y);
        partition(n / 2, x + n / 2, y);
        partition(n / 2, x, y + n / 2);
        partition(n / 2, x + n / 2, y + n / 2);
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> colorPaper[i][j];
        }
    }
    partition(n, 0, 0);
    cout << white << '\n' << blue;
}