#include <bits/stdc++.h>
using namespace std;

// DP로 풀어도 되지만 백트래킹으로 분류되어 있으므로 백트래킹으로 풀이

int arr[22];
int n, s, result = 0;

void partialSum(int target, int sum, bool check) {
    if (target > n) return;
    if (sum == s && check) {
        result++;
    }
    partialSum(target + 1, sum + arr[target], true);
    partialSum(target + 1, sum, false);
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> s;
    for (int i = 0; i < n; i++) cin >> arr[i];
    partialSum(0, 0, false);
    cout << result;
}