#include <bits/stdc++.h>
using namespace std;

int n;
long long MIN = INT_MAX;
int arr[100001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    int i = 0, j = n - 1;
    pair<int, int> result;
    while (i < j) {
        long long sum = arr[i] + arr[j];
        if (abs(MIN) > abs(sum)) {
            MIN = sum;
            result = {arr[i], arr[j]};
        }
        if (sum < 0) i++;
        else if (sum > 0) j--;
        else break;
    }
    cout << result.first << ' ' << result.second;
}