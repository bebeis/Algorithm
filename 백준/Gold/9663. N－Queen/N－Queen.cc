#include <bits/stdc++.h>
using namespace std;

int n, cnt = 0;
int full_mask;

void bt(int row, int col, int diagL, int diagR) {
    if (row == n) { cnt++; return; }

    // 놓을 수 있는 열들을 비트로 표현
    int avail = full_mask & ~(col | diagL | diagR);

    while (avail) {
        int bit = avail & -avail;   // 최하위 비트 추출
        avail -= bit;
        bt(row + 1, col | bit, (diagL | bit) << 1, (diagR | bit) >> 1);
    }
}

int main() {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    full_mask = (1 << n) - 1;
    bt(0, 0, 0, 0);
    cout << cnt;
}