#include <bits/stdc++.h>
using namespace std;

// Bottom-up으로 최적 부분 구조를 찾아서 풀려했는데 사실상 최적 부분 구조를 찾는게 불가능(독립된 부문제가 아님)
// 방법을 찾아보니 있기는 한데, 엄청난 수학적 논증이 필요하다.
// Top-down 메모이제이션으로 풀자
// 코테에서 DP문제 최적 부분 구조가 쉽게 찾을 수 없다면, 메모이제이션으로 풀자

int d[505][505]; // (i, j)에서 (n, m)으로 가는 방법의 수
int arr[505][505]; // (i, j)에서 (n, m)으로 가는 방법의 수

int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };

int n, m;

int DFS(int i, int j) {
    // 메모이제이션
    if (d[i][j] != -1) return d[i][j];

    int result = 0;
    for (int k = 0; k < 4; k++) {
        int nx = i + dx[k];
        int ny = j + dy[k];
        if (nx <= 0 || nx > m || ny <= 0 || ny > n) continue;
        if (arr[i][j] > arr[nx][ny]) result += DFS(nx, ny);
    }
    return d[i][j] = result;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> m >> n;
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> arr[i][j];
        }
    }
    fill(&d[0][0], &d[m][n], -1);
    d[m][n] = 1;
    cout << DFS(1, 1);
}