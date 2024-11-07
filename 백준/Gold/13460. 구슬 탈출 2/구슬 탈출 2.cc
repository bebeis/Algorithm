#include <bits/stdc++.h>
using namespace std;

// 4방향 기울리기
char board[11][11];
bool visited[11][11];
int d[11][11];
pair<int, int> R;
pair<int, int> B;
int n, m;
int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
            if (board[i][j] == 'R') R = {i, j};
            else if (board[i][j] == 'B') B = {i, j};
        }
    }
    queue<pair<pair<int, int>, int>> red_q;
    queue<pair<int, int>> blue_q;
    red_q.push({R, 1});
    blue_q.push(B);

    while (!red_q.empty() && !blue_q.empty()) {
        auto [r, cnt] = red_q.front();
        int rx = r.first;
        int ry = r.second;
        auto [bx, by] = blue_q.front();
        red_q.pop(); blue_q.pop();
        if (cnt > 10) break;

        for (int i = 0; i < 4; i++) {
            int nrx = rx; int nry = ry;
            int nbx = bx; int nby = by;
            bool redHole = false;
            bool blueHole = false;
            while (board[nrx + dx[i]][nry + dy[i]] != '#') {
                nrx += dx[i];
                nry += dy[i];
                if (board[nrx][nry] == 'O') redHole = true;
            }
            
            while (board[nbx + dx[i]][nby + dy[i]] != '#') {
                nbx += dx[i];
                nby += dy[i];
                if (board[nbx][nby] == 'O') blueHole = true;
            }

            if (blueHole == true) continue;

            if (nrx == nbx && nry == nby) {
                if (i == 0) { // 아래로 기울임
                    if (rx > bx) nbx--;
                    else nrx--;
                }
                else if (i == 2) { // 위로 기울임
                    if (rx > bx) nrx++;
                    else nbx++;
                } 
                else if (i == 1) { // 오른쪽 기울임
                    if (ry > by) nby--;
                    else nry--;
                } else if (i == 3) { // 왼쪽 기울임
                    if (ry < by) nby++;
                    else nry++;
                }
            }
            if (redHole == true) {
                cout << cnt;
                return 0;
            }
            
            red_q.push({{nrx, nry}, cnt + 1});
            blue_q.push({nbx, nby});
        }
    }
    cout << -1;
}