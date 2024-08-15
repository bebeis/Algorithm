#include <bits/stdc++.h>
using namespace std;

// 사영했을 때 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다
// 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다
// 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값
// 소공에서 했던 테트리스 PTSD가 오는 문제

// n이 매우 작음 --> 백트래킹으로 일일히 체크

int n;
int board[21][21];
bool bFixed[21][21];
int result = 0;

void MoveLeft() {
    for (int i = 0; i < n; i++) {
        // 블록을 최대한 왼쪽으로 밀어넣는다
        int LEmpty = 0;
        int LBlock = 1;
        while (LEmpty < n - 1 && LBlock < n) {
            if (board[i][LBlock] == 0 || LEmpty >= LBlock) {
                LBlock++;
                continue;
            }
            if (board[i][LEmpty] != 0) {
                LEmpty++;
                continue;
            }
            swap(board[i][LEmpty], board[i][LBlock]);
            swap(bFixed[i][LEmpty], bFixed[i][LBlock]);
            LEmpty++;
            LBlock++;
        }
    }
}

void MergeLeft() {
    MoveLeft();
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < n; j++) {
            if (bFixed[i][j - 1]) continue;
            if (board[i][j - 1] == board[i][j]) {
                board[i][j - 1] *= 2;
                result = max(result, board[i][j - 1]);
                bFixed[i][j - 1] = true;
                board[i][j] = 0;
                MoveLeft();
            }
        }
    }
}

void MoveRight() {
    for (int i = 0; i < n; i++) {
        int REmpty = n - 1;
        int RBlock = n - 2;
        while (REmpty > 0 && RBlock >= 0) {
            if (board[i][RBlock] == 0 || REmpty <= RBlock) {
                RBlock--;
                continue;
            }
            if (board[i][REmpty] != 0) {
                REmpty--;
                continue;
            }
            swap(board[i][REmpty], board[i][RBlock]);
            swap(bFixed[i][REmpty], bFixed[i][RBlock]);
            REmpty--;
            RBlock--;
        }
    }
}

void MoveUp() {
    for (int j = 0; j < n; j++) {
        int UEmpty = 0;
        int UBlock = 1;
        while (UEmpty < n - 1 && UBlock < n) {
            if (board[UBlock][j] == 0 || UEmpty >= UBlock) {
                UBlock++;
                continue;
            }
            if (board[UEmpty][j] != 0) {
                UEmpty++;
                continue;
            }
            swap(board[UEmpty][j], board[UBlock][j]);
            swap(bFixed[UEmpty][j], bFixed[UBlock][j]);
            UEmpty++;
            UBlock++;
        }
    }
}

void MoveDown() {
    for (int j = 0; j < n; j++) {
        int DEmpty = n - 1;
        int DBlock = n - 2;
        while (DEmpty > 0 && DBlock >= 0) {
            if (board[DBlock][j] == 0 || DEmpty <= DBlock) {
                DBlock--;
                continue;
            }
            if (board[DEmpty][j] != 0) {
                DEmpty--;
                continue;
            }
            swap(board[DEmpty][j], board[DBlock][j]);
            swap(bFixed[DEmpty][j], bFixed[DBlock][j]);
            DEmpty--;
            DBlock--;
        }
    }
}

void MergeRight() {
    MoveRight();
    for (int i = 0; i < n; i++) {
        for (int j = n - 2; j >= 0; j--) {
            if (bFixed[i][j + 1]) continue;
            if (board[i][j + 1] == board[i][j]) {
                board[i][j + 1] *= 2;
                result = max(result, board[i][j + 1]);
                bFixed[i][j + 1] = true;
                board[i][j] = 0;
                MoveRight();
            }
        }
    }
}

void MergeUp() {
    MoveUp();
    for (int j = 0; j < n; j++) {
        for (int i = 1; i < n; i++) {
            if (bFixed[i - 1][j]) continue;
            if (board[i - 1][j] == board[i][j]) {
                board[i - 1][j] *= 2;
                result = max(result, board[i - 1][j]);
                bFixed[i - 1][j] = true;
                board[i][j] = 0;
                MoveUp();
            }
        }
    }
}

void MergeDown() {
    MoveDown();
    for (int j = 0; j < n; j++) {
        for (int i = n - 2; i >= 0; i--) {
            if (bFixed[i + 1][j]) continue;
            if (board[i + 1][j] == board[i][j]) {
                board[i + 1][j] *= 2;
                result = max(result, board[i + 1][j]);
                bFixed[i + 1][j] = true;
                board[i][j] = 0;
                MoveDown();
            }
        }
    }
}


void (*fp[4])() = {MergeLeft, MergeRight, MergeUp, MergeDown};


void FindMaxBlock(int cnt) {
    if (cnt == 5) return;
    for (int i = 0; i < 4; i++) {
        int temp_board[21][21];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                temp_board[y][x] = board[y][x];
            }
        }
        memset(bFixed, 0, sizeof(bFixed));
        fp[i]();
        FindMaxBlock(cnt + 1);
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                board[y][x] = temp_board[y][x];
            }
        }
        memset(bFixed, 0, sizeof(bFixed));
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
            result = max(result, board[i][j]);
        }
    }
    FindMaxBlock(0);
    cout << result;
}