#include <bits/stdc++.h>
using namespace std;

// 북, 동, 남, 서
int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };

int n, m, i, j, dir, cnt = 0;
int arr[51][51];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m >> i >> j >> dir;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) cin >> arr[i][j];
    }
    while (1) {
        // 1
        if (arr[i][j] == 0) {
            arr[i][j] = 2;
            cnt++;
        } else {
            // 주변 4칸 체크
            int rooms = 0;
            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (arr[nx][ny] == 0) rooms++;
            }
            // 2번
            if (rooms == 0) {
                int nx = i - dx[dir];
                int ny = j - dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != 1) {
                    i = nx;
                    j = ny;
                } else {
                    break;
                }
            } else { // 3번
                dir = ((dir == 0) ? 3 : dir - 1);
                int nx = i + dx[dir];
                int ny = j + dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                    i = nx;
                    j = ny;
                }
            }
        }
    }
    cout << cnt;
}