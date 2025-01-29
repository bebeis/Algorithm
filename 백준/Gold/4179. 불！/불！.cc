#include <bits/stdc++.h>
using namespace std;

// BFS를 두 군데에서 해야할듯?
// 불 퍼지는 걸 먼저 거리계산하고, 그 다음에 지훈이의 이동 여부를 계산해보자.
// O(rclogn)이하로 풀이
// 틀린 이유 1. 모서리에서 탈출해야 하는데, 모서리 탈출 조건에서 == 1을 빼먹음(r, c만 체크함)
// 틀린 이유 2. 메모리 초과 -> jihun이가 방문한 곳을 다시 방문하지 않도록 하는 걸 빼먹음.
// 틀린 이유 3. fireDist가 0인 경우는 jihunDist와 비교를 하지 않아야 하는데 비교해버림
// 틀린 이유 4. 모서리에서 시작하는 케이스를 생각하지 못함.
// JF
// FF

int r, c; 
char board[1001][1001];
int fireDist[1001][1001];
int jihunDist[1001][1001];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    queue<pair<int, int>> JQ;
    queue<pair<int, int>> FQ;
    cin >> r >> c;
    for (int i = 1; i <= r; i++) {
        for (int j = 1; j <= c; j++) {
            cin >> board[i][j];
            if (board[i][j] == 'J') {
                JQ.push({i, j});
                jihunDist[i][j] = 1;
            }
            else if (board[i][j] == 'F') {
                FQ.push({i, j});
                fireDist[i][j] = 1;
            }
        }
    }

    auto [cx, cy] = JQ.front();
    if (cx == 1 || cx == r || cy == 1 || cy == c) {
        cout << 1;
        return 0;
    }

    while (!FQ.empty()) {
        auto [cx, cy] = FQ.front();
        FQ.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 1 || nx > r || ny < 1 || ny > c) continue;
            if (board[nx][ny] == '#' || fireDist[nx][ny] != 0) continue; 
            fireDist[nx][ny] = fireDist[cx][cy] + 1;
            FQ.push({nx, ny});
        }
    }
    
    while (!JQ.empty()) {
        auto [cx, cy] = JQ.front();
        JQ.pop();

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 1 || nx > r || ny < 1 || ny > c) continue;
            if (board[nx][ny] == '#' || board[nx][ny] == 'F') continue;
            if (jihunDist[nx][ny] > 0) continue;
            if (fireDist[nx][ny] != 0 && fireDist[nx][ny] <= jihunDist[cx][cy] + 1) continue;
            if (nx == r || ny == c || nx == 1 || ny == 1) {
                cout << jihunDist[cx][cy] + 1;
                return 0;
            }
            jihunDist[nx][ny] = jihunDist[cx][cy] + 1;
            JQ.push({nx, ny});
        }
    }
    cout << "IMPOSSIBLE";
}