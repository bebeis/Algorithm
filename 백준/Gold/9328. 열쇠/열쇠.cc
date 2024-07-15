#include <bits/stdc++.h>
using namespace std;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

// 건물밖에서 출발점을 찾을 때 키를 통해서 들어가는 경우를 체크안해서 2트
// 레퍼런스로 받아서 최대한 얕은 복사가 일어나도록
// 처음에 건물 밖에서 출발점을 찾는 과정과 BFS내에서 처리 과정과 겹쳐서 메서드로 뽑아냄
void scrach(queue<pair<int, int>>& Q, bool vis[101][101], char adj[101][101], bool keys[26], int& count, int x, int y, bool& getKey) {
    if (adj[x][y] == '.' && !vis[x][y]) {
        vis[x][y] = 1;
        Q.push({x, y});
    } else if (adj[x][y] == '$' && !vis[x][y]) {
        vis[x][y] = 1;
        count++;
        adj[x][y] = '.';
        Q.push({x, y});
    } else if (isupper(adj[x][y]) && !vis[x][y]) {
        if (keys[adj[x][y] - 'A']) {
            vis[x][y] = 1;
            Q.push({x, y});
        }
    } else if (islower(adj[x][y]) && !vis[x][y]) {
        vis[x][y] = 1;
        if (!keys[adj[x][y] - 'a']) {
            keys[adj[x][y] - 'a'] = true;
            getKey = true;
        }
        Q.push({x, y});
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cout.tie(0);
    cin.tie(0);
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        int count = 0;
        string key_string;
        char adj[101][101];
        bool keys[26] = {0, };
        cin >> n >> m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> adj[i][j];
            }
        }
        cin >> key_string;
        if (key_string != "0") {
            for (char c : key_string) {
                keys[c - 'a'] = true;
            }
        }

        // 계속 순회를 한다.
        // 순회 후 키를 얻지 못하는 경우 더 이상 순회하는 것이 의미없음 --> BFS 종료
        bool getKey = true;
        while (getKey) {
            getKey = false;
            queue<pair<int, int>> Q;
            bool vis[101][101] = {0, };

            // 건물 밖에서 출입구를 찾는 과정
            for (int i = 0; i < m; i++) {
                scrach(Q, vis, adj, keys, count, 0, i, getKey);        // 위쪽
                scrach(Q, vis, adj, keys, count, n - 1, i, getKey);    // 아래쪽
            }
            for (int i = 0; i < n; i++) {
                scrach(Q, vis, adj, keys, count, i, 0, getKey);        // 왼쪽
                scrach(Q, vis, adj, keys, count, i, m - 1, getKey);    // 오른쪽
            }

            // BFS
            while (!Q.empty()) {
                auto cur = Q.front();
                Q.pop();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.first + dx[i];
                    int ny = cur.second + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (vis[nx][ny]) continue;
                    scrach(Q, vis, adj, keys, count, nx, ny, getKey);
                }
            }
        }
        cout << count << '\n';
    }
}
