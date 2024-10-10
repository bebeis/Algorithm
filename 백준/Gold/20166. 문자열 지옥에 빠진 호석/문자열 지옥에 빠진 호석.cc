#include <bits/stdc++.h>
using namespace std;

int n, m, k;
char arr[11][11];
string target[1001];
unordered_map<string, int> hm;

void DFS(int x, int y, string cur_string) {
    if (hm.contains(cur_string)) hm[cur_string] += 1;
    if (cur_string.length() >= 5) return;
    
    // 8 방향 이동
    for(int dx = -1; dx <= 1; dx++) {
        for(int dy = -1; dy <= 1; dy++) {
            if(dx == 0 && dy == 0) continue;
            int nx = (x + dx + n) % n;
            int ny = (y + dy + m) % m;
            DFS(nx, ny, cur_string + arr[nx][ny]);
        }
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m >> k;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) cin >> arr[i][j];
    }

    for (int i = 0; i < k; i++) {
        cin >> target[i];
        hm[target[i]] = 0;
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) DFS(i, j, string(1, arr[i][j]));
    }

    for (int i = 0; i < k; i++) cout << hm[target[i]] << '\n';
}
