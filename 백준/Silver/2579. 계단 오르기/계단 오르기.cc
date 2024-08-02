#include <bits/stdc++.h>
using namespace std;

// 계단 조건을 무시하면
// d[i] = d[i - 1] + score[i];

// i번째를 첫 번째 차원으로, 연속으로 밟은 계단의 개수를 두 번째 차원으로 설정하면 되지 않을까?

// 테이블 정의
int d[301][3]; // [1],[2]에는 해당 케이스 분류
int score[301];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> score[i];
    }
    // 기저 조건
    d[1][1] = score[1];
    // 점화식 구현
    for (int i = 2; i <= n; i++) {
        // 연속 1칸 점프해서 도착 --> 2단 점프 다음 1단
        d[i][1] = max(d[i - 2][1], d[i - 2][2]) + score[i];
        // 연속 2칸 점프해서 도착
        d[i][2] = d[i - 1][1] + score[i];
    }
    cout << max(d[n][1], d[n][2]);
}