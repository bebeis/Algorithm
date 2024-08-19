#include <bits/stdc++.h>
using namespace std;

// 첫째 줄에 가능한 빌딩 순서의 경우의 수를 1 000 000 007로 나눈 나머지를 출력한다.
// Brute force : O(n!)--> 불가능

/*
건물을 추가했을 때
L만 증가하는 경우
R만 증가하는 경우
L과 R이 그대로인 경우

3가지 케이스가 존재

d[k][i][j] = d[k - 1][i - 1][j] + d[k - 1][i][j - 1] + d[k - 1][i][j] * (k - 2) (양 끝 제외라서)
*/

int n, l, r;
long long d[101][101][101];


int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> l >> r;
    d[1][1][1] = 1;
    for (int k = 2; k <= n; k++) {
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= r; j++) {
                d[k][i][j] = ((long long)d[k - 1][i - 1][j] + d[k - 1][i][j - 1] + d[k - 1][i][j] * (k - 2)) % 1000000007;
            }
        }
    }
    cout << d[n][l][r];
}