#include <bits/stdc++.h>
using namespace std;

int h, w;
int cnt = 0;
int arr[501][501];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> h >> w;
    for (int i = 0; i < w; i++) {
        int height;
        cin >> height;
        for (int j = 0; j < height; j++) arr[j][i] = 1;  // 블록에 해당하는 cell을 1로 잡아둠
    }
    for (int j = 0; j < w; j++) {
        for (int i = 0; i < h; i++) {
            if (arr[i][j] == 1) continue;
            // 아래쪽, 왼쪽, 오른쪽이 모두 벽으로 막혀있어야 한다.
            // 아래쪽
            if (i > 0 && arr[i - 1][j] != 1) continue;
            // 왼쪽
            if (j == 0) continue;
            else if (arr[i][j - 1] != 1) continue;
            // 오른쪽
            bool blockRight = false;
            if (j == w - 1) continue;
            else {
                for (int k = j + 1; k < w; k++) {
                    if (arr[i][k] == 1) {
                        blockRight = true;
                        break;
                    }
                }
                if (!blockRight) continue;
            }

            arr[i][j] = 1;
            cnt++;
        }
    }
    cout << cnt;
}