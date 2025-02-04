#include <bits/stdc++.h>
using namespace std;

int n;
int board[2200][2200];
int result[3]; // -1, 0, 1

void partition(int cx, int cy, int length) {
    int first = board[cx][cy];
    for (int i = cx; i < cx + length; i++) {
        for (int j = cy; j < cy + length; j++) {
            if (board[i][j] != first) {
                int thirdLength = length / 3;
                partition(cx, cy, thirdLength);
                partition(cx + thirdLength, cy, thirdLength);
                partition(cx + 2 * thirdLength, cy, thirdLength);

                partition(cx, cy + thirdLength, thirdLength);
                partition(cx + thirdLength, cy + thirdLength, thirdLength);
                partition(cx + 2 * thirdLength, cy + thirdLength, thirdLength);

                partition(cx, cy + thirdLength * 2, thirdLength);
                partition(cx + thirdLength, cy + thirdLength * 2, thirdLength);
                partition(cx + 2 * thirdLength, cy + thirdLength * 2, thirdLength);
                return;
            }
        }
    }
    result[first + 1]++;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) cin >> board[i][j];
    }

    partition(0, 0, n);
    cout << result[0] << '\n';
    cout << result[1] << '\n';
    cout << result[2];
}