#include <bits/stdc++.h>
using namespace std;

// 문제 핵심 : 정육면체 각 면을 어떻게 인덱스에 대응시킬 것인가

int n, m, x, y, k;
int board[21][21];
pair<int, int> bottom = {3, 1};
pair<int, int> top = {1, 1};
int dice[7];
int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

void rotate(int dir) {
	int tmp = dice[0];
	if (dir == 1) {
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = tmp;
	}
	else if (dir == 2) {
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = tmp;
	}
	else if (dir == 3) {
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = tmp;
	}
	else if (dir == 4) {
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = tmp;
	}
}

int main(void) {
    cin >> n >> m >> x >> y >> k;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) cin >> board[i][j];
    }
    while (k--) {
        int dir; cin >> dir;
        int nx = x + dx[dir - 1];
        int ny = y + dy[dir - 1];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        rotate(dir);
        if (board[nx][ny] == 0) board[nx][ny] = dice[0];
        else {
            dice[0] = board[nx][ny];
            board[nx][ny] = 0;
        }
        x = nx;
        y = ny;
        cout << dice[1] << '\n';
    }
}