#include <bits/stdc++.h>
using namespace std;

int n;
int arr[10002];
long long cnt = 0;
// O(n^2logn 이하로 풀이)
// a + b + c = 0이 되야 한다
// -> a + b = -c인 (a, b)의 쌍을 찾는다. -> n^2logn
// 이 때, a 와 b와 c가 모두 달라야 한다.

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            auto left = lower_bound(arr + j + 1, arr + n, -arr[i] - arr[j]);
            auto right = upper_bound(arr + j + 1, arr + n, -arr[i] - arr[j]);
            // 무조건 중복되는 경우가 없기 때문에 아래 로직 필요 X. 여기서 TLE 발생
            // for (auto k = left; k < right; k++) {
            //     if (arr + i == k || arr + j == k) continue;
            //     // cout << arr[i] << ' ' << arr[j] << ' ' << *k << '\n';
            //     cnt++;
            // }
            cnt += right - left;
        }
    }
    cout << cnt;
}