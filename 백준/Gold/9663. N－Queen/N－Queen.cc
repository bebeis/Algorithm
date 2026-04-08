/**
 * 하나의 열에 최대 하나의 퀸만 배치할 수 있음 -> 이걸 스택의 상태로 유지
 */

#include <bits/stdc++.h>
using namespace std;

int n;
bool horizon[17]; // x = a
bool diagRight[32]; // x - y = a - b + n
bool diagLeft[32]; // x + y = a + b
int cnt = 0;

void bt(int b) {
    if (b == n) {
        cnt++;
        return;
    }

    for (int a = 0; a < n; a++) {
        if (horizon[a]) continue;
        if (diagRight[a - b + n]) continue;
        if (diagLeft[a + b]) continue;

        horizon[a] = true;
        diagRight[a - b + n] = true;
        diagLeft[a + b] = true;
        bt(b + 1);

        horizon[a] = false;
        diagRight[a - b + n] = false;
        diagLeft[a + b] = false;
    }
}

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    cin >> n;

    bt(0);
    cout << cnt;
}