#include <bits/stdc++.h>
using namespace std;

int arr[9][9];
int subRect[3][3][10]; // 0번 인덱스는 0의 개수
int vertical[9][10]; 
int horizon[9][10];
vector<pair<int, int>> pos;

void SolveSudoku(int idx) {
    if (idx == pos.size()) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                printf("%d", arr[i][j]);
            }
            printf("\n");
        }
        exit(0);
    }

    int x = pos[idx].first;
    int y = pos[idx].second;

    for (int k = 1; k <= 9; k++) {
        if (subRect[x / 3][y / 3][k] == 0 && 
            vertical[y][k] == 0 && 
            horizon[x][k] == 0) {

            arr[x][y] = k;
            subRect[x / 3][y / 3][k]++;
            vertical[y][k]++;
            horizon[x][k]++;

            SolveSudoku(idx + 1);

            arr[x][y] = 0;
            subRect[x / 3][y / 3][k]--;
            vertical[y][k]--;
            horizon[x][k]--;
        }
    }
}


int main(void) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            scanf("%1d", &arr[i][j]);
            if (arr[i][j] == 0) {
                pos.push_back({i, j});
            }
            subRect[i / 3][j / 3][arr[i][j]]++;
            horizon[i][arr[i][j]]++;
            vertical[j][arr[i][j]]++;
        }
    }
    SolveSudoku(0);
}