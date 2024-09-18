#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
const ull MOD = 1000000007;
// n이 매우 큼. log scale로 줄여서 풀이해야 함.
// O(logn) 접근 방법으로는 분할정복이 있음.
// 분할 정복 문제에서 특정 수의 제곱을 구할 때 분할정복을 이용했던 것을 다뤘음
// 피보나치 수열을 ^m 형태로 나타낼 수 있을까? --> matrix를 이용
/*
1 1 fn+1 fn       fn+2 fn+1
1 0 fn   fn-1     fn+1  fn 


matrix ([[1, 1], [1, 0]]) ^n 을 계산하면 fn을 얻을 수 있다.
하지만 이 방법은 O(n)이므로 주어진 시간내에 해결 불가능하다. --> 분할정복을 이용하자.

n이 짝수라면 matrix^n = (matrix^(n/2)) ^ 2
n이 홀수라면 matrix^n = (matrix^(n - 1 / 2)) ^ 2 * matrix
*/

ull n;
pair<pair<ull, ull>, pair<ull, ull>> baseMatrix = {{1, 1}, {1, 0}};

pair<pair<ull, ull>, pair<ull, ull>> MatrixMul(const pair<pair<ull, ull>, pair<ull, ull>>& lhs, const pair<pair<ull, ull>, pair<ull, ull>>& rhs) {
    pair<pair<ull, ull>, pair<ull, ull>> result;
    result.first.first = (lhs.first.first * rhs.first.first + lhs.first.second * rhs.second.first) % MOD;
    result.first.second = (lhs.first.first * rhs.first.second + lhs.first.second * rhs.second.second) % MOD;
    result.second.first = (lhs.second.first * rhs.first.first + lhs.second.second * rhs.second.first) % MOD;
    result.second.second = (lhs.second.first * rhs.first.second + lhs.second.second * rhs.second.second) % MOD;
    return result;
}

pair<pair<ull, ull>, pair<ull, ull>> GetFiboMatrix(ull exp) {
    // exp == 1
    if (exp == 1) return baseMatrix;
    // 짝수
    if (exp % 2 == 0) {
        const pair<pair<ull, ull>, pair<ull, ull>> &subMatrix = GetFiboMatrix(exp / 2);
        return MatrixMul(subMatrix, subMatrix);
    } else { // 홀수
        const pair<pair<ull, ull>, pair<ull, ull>> &subMatrix = GetFiboMatrix((exp - 1) / 2);
        return MatrixMul(MatrixMul(subMatrix, subMatrix), baseMatrix);
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    if (n == 0) {
        cout << 0;
        return 0;
    }
    pair<pair<ull, ull>, pair<ull, ull>> matrix = GetFiboMatrix(n);
    cout << matrix.first.second;
}
