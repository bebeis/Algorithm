#include <bits/stdc++.h>
using namespace std;

int r, c;
int arr[1001][1001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> r >> c;
    for (int i = 1; i <= r; i++) {
        for (int j = 1; j <= c; j++) {
            cin >> arr[i][j];
        }
    }
    if (r % 2 != 0) {
        bool right = true;  // false면 왼쪽으로 이동
        for (int i = 1; i <= r; i++) {
            if (i != 1) cout << 'D';
            for (int j = 2; j <= c; j++) {
                if (right)
                    cout << 'R';
                else
                    cout << 'L';
            }
            right = !right;
        }
    } else if (c % 2 != 0) {
        bool down = true;  // false면 위쪽으로 이동
        for (int i = 1; i <= c; i++) {
            if (i != 1) cout << 'R';
            for (int j = 2; j <= r; j++) {
                if (down)
                    cout << 'D';
                else
                    cout << 'U';
            }
            down = !down;
        }
    } else {
        int min = 1001;
        pair<int, int> pos = {0, 0};
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
                    if (arr[i][j] < min) {
                        min = arr[i][j];
                        pos = {i, j};
                    }
                }
            }
        }
        bool down = true;  // false면 위쪽으로 이동
        char verti = 'D';
        for (int i = 1; i <= c; i++) {
            if (down) verti = 'D';
            else verti = 'U';

            if (i != 1) cout << 'R';

            if ((i + 1) / 2 == (pos.second + 1) / 2) {
                char left = 'L', right = 'R';
                char horizon;
                for (int j = 1; j <= r; j++) {
                    if (j != 1) cout << verti;
                    if (j % 2 == 0) horizon = left;
                    else horizon = right;
                    if (j == pos.first) swap(left, right);
                    else cout << horizon;
                }
                i++;
                down = !down;
            } else {
                for (int j = 2; j <= r; j++) {
                    cout << verti;
                }
                down = !down;
            }
        }
    }
}