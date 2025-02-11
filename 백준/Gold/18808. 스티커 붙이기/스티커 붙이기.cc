#include <bits/stdc++.h>
using namespace std;
int n, m, k;

int board[42][42];
int sticker[102][4][12][12];
pair<int, int> stickerSize[102][4];
int cnt = 0;

/**
 *  
 */

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n >> m >> k;
    for (int c = 0; c < k; c++) {
        int x, y;
        cin >> x >> y;
        stickerSize[c][0] = {x, y};
        stickerSize[c][1] = {y, x};
        stickerSize[c][2] = {x, y};
        stickerSize[c][3] = {y, x};
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cin >> sticker[c][0][i][j];
                sticker[c][1][j][x - 1 - i] = sticker[c][0][i][j];
                sticker[c][2][x - 1 - i][y - 1 - j] = sticker[c][0][i][j];
                sticker[c][3][y - 1 - j][i] = sticker[c][0][i][j];
            }
        }
    }

    for (int t = 0; t < k; t++) {
        bool filled = false;
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 노트북에 스티커가 들어가는지 체크
                    if (i + stickerSize[t][d].first > n || j + stickerSize[t][d].second > m) continue;
                    
                    // 겹치는 부분이 있는지 체크
                    bool skip = false;
                    for (int x = 0; x < stickerSize[t][d].first; x++) {
                        for (int y = 0; y < stickerSize[t][d].second; y++) {
                            if (sticker[t][d][x][y] && board[i + x][j + y]) {
                                skip = true;
                                break;
                            }
                        }
                        if (skip) break;
                    }
                    if (skip) continue;

                    // 넣을 수 있는 경우
                    for (int x = 0; x < stickerSize[t][d].first; x++) {
                        for (int y = 0; y < stickerSize[t][d].second; y++) {
                            if (sticker[t][d][x][y]) board[i + x][j + y] = 1;
                        }
                    }
                    filled = true;
                    if (filled) break;
                }
                if (filled) break;
            }
            if (filled) break;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == 1) cnt++;
        }
    }
    cout << cnt;
}