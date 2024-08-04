#include <bits/stdc++.h>
using namespace std;

// 문제 변환
// 점수가 최대가 되려면, 밟지 않은 계단의 점수 합이 최소가 되면 된다.
// k번째를 안밟았다 --> k-1번째를 밟았다 --> k-2 에서 k-1 또는 K-3에서 k-1

// 점화식
// d(k) = min(d(k - 2), d(k - 3)) + score(k);

int d[301];
int score[301];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, total = 0;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> score[i];
        total += score[i];
    }
    // 기저 조건
    if (n <= 2) {
        cout << total;
        return 0;
    }
    d[1] = score[1]; d[2] = score[2]; d[3] = score[3];
    // 점화식 구현
    for (int i = 4; i < n; i++) {
        d[i] = min(d[i - 2], d[i - 3]) + score[i];
    }
    cout << total - min(d[n - 2], d[n - 1]);
}