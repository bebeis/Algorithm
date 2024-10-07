#include <bits/stdc++.h>
using namespace std;

int n;
int board[21][21];
int shark_x, shark_y;
int shark_size = 2;
int eaten = 0;
int total_time = 0;

// 방향: 위, 왼쪽, 오른쪽, 아래
int dx[] = { -1, 0, 0, 1 };
int dy[] = { 0, -1, 1, 0 };

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            cin >> board[i][j];
            if(board[i][j] == 9) {
                shark_x = i;
                shark_y = j;
                board[i][j] = 0; // 초기 위치를 0으로 설정
            }
        }
    }

    while (true) {
        // BFS를 위한 큐와 방문 배열 초기화
        queue<pair<int, int>> Q;
        Q.push({shark_x, shark_y});
        vector<pair<int, int>> fishes;
        int visited[21][21];
        memset(visited, -1, sizeof(visited));
        visited[shark_x][shark_y] = 0;
        int min_dist = INT32_MAX;

        while (!Q.empty()) {
            auto [x, y] = Q.front(); Q.pop();
            for(int dir= 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx <= 0 || nx > n || ny <=0 || ny >n) continue;
                if (visited[nx][ny] != -1) continue;
                if (board[nx][ny] > shark_size) continue;
                visited[nx][ny] = visited[x][y] + 1;
                if (board[nx][ny] != 0 && board[nx][ny] < shark_size) {
                    if (visited[nx][ny] < min_dist) {
                        fishes.clear();
                        min_dist = visited[nx][ny];
                        fishes.emplace_back(nx, ny);
                    }
                    else if (visited[nx][ny] == min_dist) {
                        fishes.emplace_back(nx, ny);
                    }
                }
                Q.push({nx, ny});
            }
        }

        if (fishes.empty()) break; // 더 이상 먹을 수 있는 물고기가 없으면 종료

        // 먹을 물고기 중 가장 위, 그 중 가장 왼쪽을 선택
        sort(fishes.begin(), fishes.end());
        int target_x = fishes[0].first;
        int target_y = fishes[0].second;
        int distance = visited[target_x][target_y];
        total_time += distance;
        eaten++;
        if(eaten == shark_size) {
            shark_size++;
            eaten = 0;
        }
        // 상어의 위치 업데이트
        shark_x = target_x;
        shark_y = target_y;
        // 먹은 물고기 위치를 빈 칸으로 설정
        board[target_x][target_y] = 0;
    }

    cout << total_time;
    return 0;
}
