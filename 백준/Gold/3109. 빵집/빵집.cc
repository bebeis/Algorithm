#include <bits/stdc++.h>
using namespace std;

#define x first
#define y second

char board[10001][501];
bool visited[10001][501];
int dx[] = { -1, 0, 1 };
int pipeCount = 0;
int r, c;


bool dfs(int x, int y) {
    if (y == c - 1) {
        pipeCount++;
        return true;
    }
    for (int i = 0; i < 3; i++) {
        int nx = x + dx[i];
        int ny = y + 1;
        
        if (nx < 0 || nx >= r || board[nx][ny] == 'x' || visited[nx][ny]) {
            continue;
        }
        
        visited[nx][ny] = true;
        
        if (dfs(nx, ny)){
            return true; // 경로가 완성됬다면 return으로 뒤로가기
        }
    }
    return false;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> r >> c;

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) cin >> board[i][j];
    }

    for (int i = 0; i < r; i++){
        dfs(i, 0);
    }

    cout << pipeCount;
}
