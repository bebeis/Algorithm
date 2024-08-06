#include <bits/stdc++.h>
using namespace std;

// 팰린드롬 : 거꾸로 읽어도 같은 수
// 처음에 테이블을 모두 완성한 후 질문마다 O(1)으로 처리해야 함 --> tabulation
// O(N^2) 이하로 풀이

int a[2002];
bool d[2002][2002]; // 1차원 : S, 2차원 : E

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n; cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];
    for (int j = 1; j <= n; j++) {
        for (int i = j; i >= 1; i--) {
            if (i == j) d[i][j] = 1;
            else if ((j - i == 1) && a[i] == a[j]) d[i][j] = 1;
            else if (d[i + 1][j - 1] && a[i] == a[j]) d[i][j] = 1;
        }
    }
    int m; cin >> m;
    while (m--) {
        int s, e;
        cin >> s >> e;
        cout << d[s][e] << '\n';
    }
}