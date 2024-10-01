#include <bits/stdc++.h>
using namespace std;

// O(NM) -> 1초 안에 불가능
// 가능한 cost 중에서 memory가 m 이상인걸 찾으면 되겠다.
// N <= 100, C <= 100 이므로, cost는 절대 10000을 넘지 않는다.
// O(n^3) 으로 풀면 1초 내 풀이 가능

// 틀린 이유 : 높은 cost -> 0 순서로 순회해야 하는데 0 -> 높은 cost로 순회함
// 0 -> 10001로 순회하면, 같은 물건이 또 담기는 경우가 생길 수 있음
// 0에서 3을 담았는데, 3에서 또 6을 담고, 6에서.... 요런식으로
// 따라서 가치가 높은거에서 낮은 걸로 순회해야 한다.

int n, m;
int memory[101];
int cost[101];
int dp[10001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> memory[i];
    for (int i = 0; i < n; i++) cin >> cost[i];

    for (int i = 0; i < n; i++) {
        for (int j = 10000; j >= 0; j--) {
            if (j - cost[i] >= 0) dp[j] = max(dp[j - cost[i]] + memory[i], dp[j]);
        }
    }

    for (int i = 0; i <= 10000; i++) {
        if (dp[i] >= m) {
            cout << i;
            return 0;
        }
    }
}