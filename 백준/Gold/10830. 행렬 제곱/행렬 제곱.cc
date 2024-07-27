#include <bits/stdc++.h>
using namespace std;

// idea : 분할 정복
/*
n이 짝수인 경우 : C^n = C^(n / 2) * C^(n / 2)
n이 홀수인 경우 : C^((n - 1) / 2) * C^((n - 1) / 2) * C
*/
// b는 1000억 이하, 분할정복으로 log(1000억) 으로 복잡도를 낮출 수 있다.

// b == 1일 때 1000으로 나눠서 출력 안해줘서 2트

typedef unsigned long long ull;
int n;
ull b;

vector<vector<int>> input_matrix(6, vector<int>(6, 0));

vector<vector<int>> multiply(const vector<vector<int>>& A, const vector<vector<int>>& B) {
    vector<vector<int>> result(n, vector<int>(n, 0));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            for (int k = 0; k < n; ++k) {
                result[i][j] += A[i][k] * B[k][j];
                result[i][j] %= 1000;
            }
        }
    }
    return result;
}

vector<vector<int>> matrix_pow(ull exponent) {
    if (exponent == 1) return input_matrix;
    if (exponent % 2 == 0) {
        const auto& half_pow = matrix_pow(exponent / 2);
        return multiply(half_pow, half_pow);
    } else {
        const auto& half_pow = matrix_pow((exponent - 1) / 2);
        const auto& half_pow_squared = multiply(half_pow, half_pow);
        return multiply(half_pow_squared, input_matrix);
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cin >> n >> b;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> input_matrix[i][j];
        }
    }
    if (b == 1) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cout << input_matrix[i][j] % 1000 << " ";
            }
            cout << '\n';
        }
    } else {
        const auto& result = matrix_pow(b);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cout << result[i][j] << " ";
            }
            cout << '\n';
        }
    }
}
