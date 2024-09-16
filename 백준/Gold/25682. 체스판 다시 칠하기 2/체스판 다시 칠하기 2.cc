#include <bits/stdc++.h>
using namespace std;
// O(mn)으로 풀어야 할 듯
/* 케이스는 두 가지만 존재
BWBWBW
WBWBWB
BWBWBW
...

WBWBWB
BWBWBW
WBWBWB
.....
*/

int n, m, k;
char board[2002][2002];
char whiteboard[2002][2002];
char blackboard[2002][2002];
int whitediff[2002][2002];
int blackdiff[2002][2002];
int result = 1e9+10;

int main(void) {
    scanf("%d %d %d", &n, &m, &k);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            scanf(" %c", &board[i][j]);
        }
    }
    // O(nm)
    for (int p = 1; p <= n; p++) {
        for (int i = 1; i <= m; i++) {
            blackdiff[p][i] = blackdiff[p][i - 1];
            whitediff[p][i] = whitediff[p][i - 1];
            if ((p % 2 == 1 && i % 2 == 1) || (p % 2 == 0 && i % 2 == 0)) {
                if (board[p][i] == 'W') blackdiff[p][i]++;
                else whitediff[p][i]++;
            } else {
                if (board[p][i] == 'W') whitediff[p][i]++;
                else blackdiff[p][i]++;
            }
        }
    }

    for (int y = 1; y + k - 1 <= m; y++) {
        int wdiff = 0;
        int bdiff = 0;
        for (int z = 1; z <= k; z++) {
            wdiff += whitediff[z][y + k - 1] - whitediff[z][y - 1];
            bdiff += blackdiff[z][y + k - 1] - blackdiff[z][y - 1];
        }
        result = min(result, min(wdiff, bdiff));
        for (int x = 2; x + k - 1 <= n; x++) {
            // (x - 1, y)에서 (x, y)로 이동한다면, x - 1번째 줄의 개수만큼 빠지고 x + k - 1번째 줄만큼 개수가 증가한다.
            wdiff = wdiff - (whitediff[x - 1][y + k - 1] - whitediff[x - 1][y - 1]) + whitediff[x + k - 1][y + k - 1] - whitediff[x + k - 1][y - 1];
            bdiff = bdiff - (blackdiff[x - 1][y + k - 1] - blackdiff[x - 1][y - 1]) + blackdiff[x + k - 1][y + k - 1] - blackdiff[x + k - 1][y - 1];
            result = min(result, min(wdiff, bdiff));
        }
    }
    printf("%d", result);
}
