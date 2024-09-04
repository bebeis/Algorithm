#include <bits/stdc++.h>
using namespace std;

/* BruteForce 접근
(처음에 방문할 장소 개수) n * (그 다음 장소) n - 1 * ..... 2 * 1 = n!
이를 위해 방문할 장소를 기록하는 visited 배열을 사용하고, 백트래킹으로 최솟값을 구한다.
*/

/* DP 접근
브루트포스 풀이의 문제점 : n!이라는 순열은 순서를 포함하고 있음 --> 어떤 순서로 방문했는지는 중요하지 않다.
현재 어떤 노드를 방문한 상태이고, 이 때 비용의 최소를 구하는 것을 DP 테이블의 상태로 정의한다.
노드를 방문한 상태는 부분집합으로 나타낼 수 있고, 부분집합은 비트마스킹을 통해서 2^n으로 표현 가능하다.
*/

const int INF = 1e9+10;
int n;
int w[17][17];
int d[(1 << 16) + 10][17]; // status, cur

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) cin >> w[i][j];
    }

    for (int i = 0; i < (1 << n); i++) fill(d[i], d[i] + n, INF);
    d[1][0] = 0;
    
    for (int mask = 0; mask < (1 << n); mask++) {
        for (int i = 0; i < n; i++) { // cur 위치 결정
            if (!(mask & (1 << i))) continue;
            for (int j = 0; j < n; j++) { // 다음 위치 결정
                if (!(mask & (1 << j)) && w[i][j] != 0) {
                    d[mask | (1 << j)][j] = min(d[mask | (1 << j)][j], d[mask][i] + w[i][j]);
                }
            }
        }
    }

    int result = INF;
    for (int i = 0; i < n; i++) { // 0 to i, i to 0 찾기
        if (d[(1 << n) - 1][i] == INF || w[i][0] == 0) continue;
        result = min(result, d[(1 << n) - 1][i] + w[i][0]);
    }

    cout << result;
}