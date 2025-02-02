#include <bits/stdc++.h>
using namespace std;

// 아무 생각 없이 풀면 O(21억) -> 시간초과
// log scale로 줄여야 한다.
// 분할정복 도입!

long long a, b, c;

long long result(long long b) {
    if (b == 1) return a % c;

    long long mod = result(b / 2);
    long long temp = (mod * mod) % c;

    if (b % 2 == 0) {
        return temp;
    } else {
        return (temp * (a % c)) % c;
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> a >> b >> c;
    cout << result(b);
}