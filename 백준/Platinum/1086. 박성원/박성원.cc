#include <bits/stdc++.h>
using namespace std;

// n!가지 경우의 수를 구해 모두 나누면 매우 오래걸린다(백트래킹)
// {1, 2, 3, 4, 5}
// ==> n!가지 나머지를 집합을 이용하여 풀 수 있지 않을까?
// 순서는 상관이 없다. 해당 상태에서 나머지가 x인 케이스가 몇 개인지만 알면, 그 뒤에 어떤 수가 붙냐에 따라서 미리 구해둔 결과를 이용해주면 된다.
//  (a * b) % k = ((a % k) * (b % k)) % k

string arr[16];
int n, k;
long long dp[(1 << 16)][101]; // state, 나머지 r
int rcache[51];
int cachestr[16];

int mod(const string &s, const int divisor) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
        result *= 10;
        result += s[i] - '0';
        result %= divisor;
    }
    return result;
}

long long factorial(int n) {
    if (n == 1) return 1;
    return n * factorial(n - 1);
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    cin >> k;
    dp[0][0] = 1;
    rcache[0] = 1;
    for (int i = 1; i < 51; i++) rcache[i] = (rcache[i - 1] * 10) % k;
    for (int i = 0; i < n; i++) cachestr[i] = mod(arr[i], k);

    for (int mask = 0; mask < (1 << n); mask++) {
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                int nextMask = mask | (1 << i);
                for (int j = 0; j < k; j++) {
                    int nextK = ((j * rcache[arr[i].length()]) % k + cachestr[i]) % k;
                    dp[nextMask][nextK] += dp[mask][j];
                }
            }
        }
    }
    auto divisor = factorial(n);
    auto dividened = dp[(1 << n) - 1][0];

    long long GCD = gcd(dividened, divisor);

    cout << dividened / GCD << "/" << divisor / GCD;
}