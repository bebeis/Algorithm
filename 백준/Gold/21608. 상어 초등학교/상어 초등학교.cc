#include <bits/stdc++.h>
using namespace std;

int n;
int seats[21][21];
bool isFriend[401][401];

int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int k = 0; k < n * n; k++) {
        int stu, frd;
        cin >> stu;
        for (int i = 0; i < 4; i++) {
            cin >> frd;
            isFriend[stu][frd] = true;
        }

        // 주변에 짱친이 제일 많은 자리 찾기
        pair<int, int> maxSeat;
        int maxFriends = -1;
        int maxEmpty = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] != 0) continue;
                int cnt = 0;
                int aroundEmpty = 0;
                for (int p = 0; p < 4; p++) {
                    int nx = i + dx[p];
                    int ny = j + dy[p];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (isFriend[stu][seats[nx][ny]]) cnt++;
                    if (seats[nx][ny] == 0) aroundEmpty++;
                }
                if (maxFriends < cnt) {
                    maxFriends = cnt;
                    maxSeat = {i, j};
                    maxEmpty = aroundEmpty;
                } else if (maxFriends == cnt) {
                    if (aroundEmpty > maxEmpty) {
                        maxSeat = {i, j};
                        maxEmpty = aroundEmpty;
                    } else if (aroundEmpty == maxEmpty) {
                        if (i < maxSeat.first) {
                            maxSeat = {i, j};
                        } else if (i == maxSeat.first) {
                            if (j < maxSeat.second) {
                                maxSeat = {i, j};
                            }
                        }
                    }
                }
            }
        }
        // 자리 배정
        seats[maxSeat.first][maxSeat.second] = stu;
    }

    // 만족도 체크
    int satis = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            for (int p = 0; p < 4; p++) {
                int nx = i + dx[p];
                int ny = j + dy[p];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (isFriend[seats[i][j]][seats[nx][ny]]) cnt++;
            }
            if (cnt == 1) satis += 1;
            else if (cnt == 2) satis += 10;
            else if (cnt == 3) satis += 100;
            else if (cnt == 4) satis += 1000;
        }
    }

    cout << satis;
}