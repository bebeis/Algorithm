#include <bits/stdc++.h>
using namespace std;

struct Matrix {
    int m;
    int n;

    int operator*(const Matrix& rhs) const {
        return this->m * this->n * rhs.n;
    }
};

int n;
int cnt[501][501];  // A X B, B X C, C X D...의 곱셈 횟수
Matrix matrix[501];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> matrix[i].m >> matrix[i].n;
    
    for (int i = 1; i <= n; i++) {
        cnt[i][i] = 0;
    }
    
    for (int length = 1; length < n; length++) {
        for (int i = 1; i <= n - length; i++) {
            int j = i + length;
            cnt[i][j] = 1e9+10;
            for (int k = i; k < j; k++) {
                cnt[i][j] = min(cnt[i][j], cnt[i][k] + cnt[k + 1][j] + matrix[i].m * matrix[k].n * matrix[j].n);
            }
        }
    }
    cout << cnt[1][n];
}
