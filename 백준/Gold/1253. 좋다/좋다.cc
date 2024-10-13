#include <bits/stdc++.h>
using namespace std;

// n이 2000 이하 -> O(N^2logN)까지 가능
// 틀린 이유 : 음수를 고려하지 않음. 음수 로직을 따로 고려해야 함
// 음수가 존재할 때는 i번째 앞 수와 뒤 수를 골라서 i번째 수를 형성할 수 있음.

int n;
long long arr[2001];
int cnt = 0;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    if (n <= 2) {
        cout << 0;
        return 0;
    }
    for (int i = 0; i < n; i++) {
        long long target = arr[i];
        int left = 0, right = n - 1;
        while (left < right) {
            if (left == i) {
                left++;
                continue;
            }
            if (right == i) {
                right--;
                continue;
            }

            long long sum = arr[left] + arr[right];
            if (sum == target) {
                cnt++;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
    cout << cnt;
}