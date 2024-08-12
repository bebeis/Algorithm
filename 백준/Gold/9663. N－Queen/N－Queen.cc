#include <bits/stdc++.h>
using namespace std;

int visited[16][16];
int n;
int cnt = 0;

void getWay(int row) {
    if (row == n) {
        cnt++;
        return;
    }
    for (int i = 0; i < n; i++) {
        if (visited[row][i]) continue;
        for (int j = row; j < n; j++) visited[j][i]++;
        for (int j = row, diag = i; j < n && diag < n; j++, diag += 1) visited[j][diag]++;
        for (int j = row, diag = i; j < n && diag >= 0; j++, diag -= 1) visited[j][diag]++;
        getWay(row + 1);
        for (int j = row; j < n; j++) visited[j][i]--;
        for (int j = row, diag = i; j < n && diag < n; j++, diag += 1) visited[j][diag]--;
        for (int j = row, diag = i; j < n && diag >= 0; j++, diag -= 1) visited[j][diag]--;
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    getWay(0);
    cout << cnt;
}