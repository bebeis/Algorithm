#include <bits/stdc++.h>
using namespace std;

// 메모리 제한 128MB ==> DP로 결과 저장은 불가능
// 분할 정복으로 접근하지만 최대한 이전 결과를 이용할 수 있도록 구현
long long remainder(long long a, long long b, long long c) {
    if (b == 1) {
        return a % c;
    }
    long long result = remainder(a, b >> 1, c);
    if (b % 2 == 0) {
        return result * result % c;
    } else {
        return (((result * result) % c) * a) % c;
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    long long a, b, c;
    cin >> a >> b >> c;
    cout << remainder(a, b, c);
}