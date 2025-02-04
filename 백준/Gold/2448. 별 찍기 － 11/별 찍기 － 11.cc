#include <bits/stdc++.h>
using namespace std;

char board[3100][6200];
int n;

void initBoard(int n) {
    for (int i = 0; i < n; i++) {
        fill(board[i], board[i] + 2 * n, ' ');
        board[i][2 * n] = '\0';
    }
}

// 재귀 호출 순서 : 위 -> 왼 -> (가운데 빔) -> 오
void recordStar(int k, int centerX, int centerY) {
    
    if (k == 3) {
        board[centerY][centerX] = '*';

        board[centerY + 1][centerX - 1] = '*';
        board[centerY + 1][centerX + 1] = '*';

        board[centerY + 2][centerX - 2] = '*';
        board[centerY + 2][centerX - 1] = '*';
        board[centerY + 2][centerX] = '*';
        board[centerY + 2][centerX + 1] = '*';
        board[centerY + 2][centerX + 2] = '*';
        return;
    }
    
    recordStar(k / 2, centerX, centerY);
    recordStar(k / 2, centerX - k / 2, centerY + k / 2);
    recordStar(k / 2, centerX + k / 2, centerY + k / 2);
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n;
    initBoard(n);
    recordStar(n, n - 1, 0);
    for (int i = 0; i < n; i++) cout << board[i] << '\n';
}
