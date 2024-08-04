#include <bits/stdc++.h>
using namespace std;

// 각 TC가 같은 부문제를 공유한다
// --> 처음에 전부 다 저장해두고 해당 TC 값만 출력해준다
// 반드시 한 개의 차원만을 이용해야 한다(두 개 쓰면 MLE 예상)
// i부터 j까지의 누적 합 --> j까지의 누적합 - (i - 1)까지의 누적합
int d[100001];
int n, m;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int val;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> val;
        d[i] = d[i - 1] + val;
    }

    while (m--) {
        int i, j;
        cin >> i >> j;
        cout << d[j] - d[i - 1] << '\n';
    }
}