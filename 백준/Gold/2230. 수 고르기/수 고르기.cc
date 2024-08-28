#include <bits/stdc++.h>
using namespace std;

// n <= 100 000 --> O(nlogn) 이하로 풀이

int arr[100001];
int result = INT_MAX;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    int ed = 0;
    for (int st = 0; st < n; st++)  {
        while (ed < n && arr[ed] - arr[st] < m) ed++;
        if (ed == n) break;
        result = min(result, arr[ed] - arr[st]);
    }
    cout << result;
}