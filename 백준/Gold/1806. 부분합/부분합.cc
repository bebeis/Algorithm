#include <bits/stdc++.h>
using namespace std;

int n, s;
int arr[100001];
int result = INT_MAX;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> s;
    for (int i = 0; i < n; i++) cin >> arr[i];
    int ed = 0, sum = 0;
    for (int st = 0; st < n; st++) {
        while (ed < n && sum < s) sum += arr[ed++];
        if (ed == n && sum < s) break;
        result = min(result, ed - st);
        sum -= arr[st];
    }
    if (result == INT_MAX) result = 0;
    cout << result;
}