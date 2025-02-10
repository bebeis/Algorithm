#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[10][10];
int hiddenArea = 100;
vector<pair<int, int>> cctvPos;
int dx[] = {};
int dy[] = {};

void fillLeft(int cx, int cy, queue<pair<int, int>> &Q) {
    for (int i = cy - 1; i >= 0; i--) {
        if (board[cx][i] == 6) break;
        if (board[cx][i] == 0) {
            board[cx][i] = 8;
            Q.push({cx, i});
        }
    }
}

void fillRight(int cx, int cy, queue<pair<int, int>> &Q) {
    for (int i = cy + 1; i < m; i++) {
        if (board[cx][i] == 6) break;
        if (board[cx][i] == 0) {
            board[cx][i] = 8;
            Q.push({cx, i});
        }
    }
}

void fillDown(int cx, int cy, queue<pair<int, int>> &Q) {
    for (int i = cx + 1; i < n; i++) {
        if (board[i][cy] == 6) break;
        if (board[i][cy] == 0) {
            board[i][cy] = 8;
            Q.push({i, cy});
        }
    }
}

void fillUp(int cx, int cy, queue<pair<int, int>> &Q) {
    for (int i = cx - 1; i >= 0; i--) {
        if (board[i][cy] == 6) break;
        if (board[i][cy] == 0) {
            board[i][cy] = 8;
            Q.push({i, cy});
        }
    }
}

void pop(queue<pair<int, int>> &Q) {
    while (!Q.empty()) {
        board[Q.front().first][Q.front().second] = 0;
        Q.pop();
    }
}

void backtracking(int cur) {
    if (cur == cctvPos.size()) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) cnt++;
            }
        }
        if (cnt < hiddenArea) hiddenArea = cnt;
        return;
    }

    int cx = cctvPos[cur].first;
    int cy = cctvPos[cur].second;
    queue<pair<int, int>> Q;

    if (board[cx][cy] == 1) {
        // 좌
        fillLeft(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 상
        fillUp(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 우
        fillRight(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 하
        fillDown(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
    } else if (board[cx][cy] == 2) {
        // 좌 우
        fillLeft(cx, cy, Q);
        fillRight(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 상 하
        fillUp(cx, cy, Q);
        fillDown(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
    } else if (board[cx][cy] == 3) {
        // 좌 상
        fillLeft(cx, cy, Q);
        fillUp(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 상 우
        fillUp(cx, cy, Q);
        fillRight(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 우 하
        fillRight(cx, cy, Q);
        fillDown(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 하 좌
        fillDown(cx, cy, Q);
        fillLeft(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
    } else if (board[cx][cy] == 4) {
        // 좌 상 우
        fillLeft(cx, cy, Q);
        fillUp(cx, cy, Q);
        fillRight(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 상 우 하
        fillUp(cx, cy, Q);
        fillRight(cx, cy, Q);
        fillDown(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 우 하 좌
        fillRight(cx, cy, Q);
        fillDown(cx, cy, Q);
        fillLeft(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
        // 하 좌 상
        fillDown(cx, cy, Q);
        fillLeft(cx, cy, Q);
        fillUp(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
    } else if (board[cx][cy] == 5) {
        fillDown(cx, cy, Q);
        fillLeft(cx, cy, Q);
        fillUp(cx, cy, Q);
        fillRight(cx, cy, Q);
        backtracking(cur + 1);
        pop(Q);
    }
}



int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
            if (board[i][j] != 0 && board[i][j] != 6) cctvPos.push_back({i, j});
        }
    }
    backtracking(0);
    cout << hiddenArea;
}