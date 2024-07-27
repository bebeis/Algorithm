#include <bits/stdc++.h>
using namespace std;

int N, r, c;

int recursive(int x, int y, int n) {
    if (n == 0) return 0;
    int half = 1 << (n - 1);
    int quarter = half * half;

    // case 1 : 2사분면
    if (r < x + half && c < y + half) return recursive(x, y, n - 1);
    // case 2 : 1사분면
    else if (r < x + half && c >= y + half) return quarter + recursive(x, y + half, n - 1);
    // case 3 : 3사분면
    else if (r >= x + half && c < y + half) return 2 * quarter + recursive(x + half, y, n - 1);
    // case 4 : 4사분면
    else return 3 * quarter + recursive(x + half, y + half, n - 1);
}


int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    cin >> N >> r >> c;
    cout << recursive(0, 0, N);
}