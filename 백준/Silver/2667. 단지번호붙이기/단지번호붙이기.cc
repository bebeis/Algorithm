#include <bits/stdc++.h>
using namespace std;

// 방문 배열이 필요없음
int adj[30][30];
int n;

// 변위
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int BFS(int x, int y) {
    queue<pair<int, int>> Q;
    Q.push({x, y});
    int cnt = 0;
    adj[x][y] = 0;
    while (!Q.empty()) {
        auto cur = Q.front();
        Q.pop();
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (adj[nx][ny]) {
                Q.push({nx, ny});
                adj[nx][ny] = 0;
            }
        }
    }
    return cnt;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int count = 0;
    string input;
    vector<int> num;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        for (int j = 0; j < n; j++) {
            adj[i][j] = input[j] - '0';
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (adj[i][j]) {
                count++;
                num.push_back(BFS(i, j));
            }
        }
    }
    cout << count << '\n';
    sort(num.begin(), num.end());
    for (int x : num) {
        cout << x << '\n';
    }
}