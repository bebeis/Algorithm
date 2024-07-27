#include <bits/stdc++.h>
using namespace std;

// n이 매우 커서 메모이제이션을 통한 DP 풀이는 불가능
// log scale로 복잡도를 낮춰야 한다.
// 단순 분할 정복의 시간복잡도 : 2^n --> 절대 1초안에 통과 불가능
// 거듭 제곱 형태로 소문제를 분할해야 한다
// 피보나치를 행렬을 이용하여 거듭 제곱 형태로 풀이할 수 있다.

typedef unsigned long long ull;
ull n;

/* base_matrix 
0 1
1 1
*/

vector<vector<ull>> base_matrix = {{0, 1}, {1, 1}};

vector<vector<ull>> multiply(const vector<vector<ull>>& A, const vector<vector<ull>>& B) {
    vector<vector<ull>> result(2, vector<ull>(2, 0));
    for (int i = 0; i < 2; ++i) {
        for (int j = 0; j < 2; ++j) {
            for (int k = 0; k < 2; ++k) {
                result[i][j] += A[i][k] * B[k][j];
                result[i][j] %= 1000000;
            }
        }
    }
    return result;
}

vector<vector<ull>> matrix_pow(ull exponent) {
    if (exponent == 1) return base_matrix;
    if (exponent % 2 == 0) {
        const auto& half_pow = matrix_pow(exponent / 2);
        return multiply(half_pow, half_pow);
    } else {
        const auto& half_pow = matrix_pow((exponent - 1) / 2);
        const auto& half_pow_squared = multiply(half_pow, half_pow);
        return multiply(half_pow_squared, base_matrix);
    }
}
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cin >> n;
    if (n == 0) {
        cout << 0;
        return 0;
    }
    const auto& result = matrix_pow(n);
    cout << result[0][1];
}