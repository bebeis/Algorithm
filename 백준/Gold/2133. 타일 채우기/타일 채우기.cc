#include <bits/stdc++.h>
using namespace std;

int n;
int d[31];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    d[0] = 1;
    d[2] = 3;
    // 홀수 번째는 무조건 0
    for (int i = 4; i <= n; i += 2) {
        d[i] = 3 * d[i - 2];
        for (int j = i - 4; j >= 0; j -= 2) {
            d[i] += 2 * d[j];
        }
    }
    cout << d[n];
}