#include <bits/stdc++.h>
using namespace std;

// 일반적인 dp 풀이를 떠올리면 1부터 n까지 d[i + 1][현재 수 +- 1] += d[i][현재 수] 요런식으로 구할텐데
// 문제 조건이 0부터 9까지 모두 등장해야 한다고 한다.
// n = 10일 때 1234567890 부터 시작한다.
// 현재 어떤 수가 존재하는지를 비트를 이용해서 나타낼 수 있다.
// 최종적으로 n = 40일 때 10개의 비트가 모두 1로 켜져있는 것의 수를 찾으면 되지 않을까?

const int MOD = 1000000000;
int dp[101][10][(1 << 10)]; // n, 마지막으로 추가한 수, 상태
int n;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= 9; i++) {
        dp[1][i][1 << i] = 1;
    }

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < 10; j++) {
            for (int mask = 0; mask < (1 << 10); mask++) {
                if (dp[i][j][mask] == 0) continue; // j번째로 끝나지 않은 경우
                if (j > 0) dp[i + 1][j - 1][mask | (1 << (j - 1))] = (dp[i + 1][j - 1][mask | (1 << (j - 1))] + dp[i][j][mask]) % MOD;
                if (j < 9) dp[i + 1][j + 1][mask | (1 << (j + 1))] = (dp[i + 1][j + 1][mask | (1 << (j + 1))] + dp[i][j][mask]) % MOD;
            }
        }
    }

    int result = 0;
    for (int i = 0; i <= 9; i++) {
        result = (result + dp[n][i][(1 << 10) - 1]) % MOD;
    }
    cout << result;
}