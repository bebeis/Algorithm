#include <bits/stdc++.h>
using namespace std;

int weight[1001];
int n;
int result;
int cur_sum;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> weight[i];
    cur_sum = accumulate(weight, weight + n, 0);
    result = cur_sum + 1;
    sort(weight, weight + n, greater<int>());
    for (int i = 0; i < n; i++) {
        cur_sum -= weight[i];
        if (weight[i] > cur_sum + 1) result = cur_sum + 1;
    }
    cout << result;
}