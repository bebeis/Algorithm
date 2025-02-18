#include <bits/stdc++.h>
using namespace std;

// 브루트 포스 : 0 ~ max(arr)까지 직접 다 잘라보며 길이의 합 최댓값을 찾는다.
// O(NK)
// 가능한 랜선 길이의 범위: 0 ~ max(arr): 21억
// N을 로그 스케일로 줄여야 한다.
// 길이를 줄일수록 랜선의 개수는 늘어난다.
// 투머치하지 않고 딱 N이되는 순간이 최대가 될 것이다.
// upper_bound에서 1칸 전이 된다는 것.

int k, n;
long long arr[10003];

bool check(long long length) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += arr[i] / length;
    }
    if (sum >= n) return true;
    return false;
}

long long findMaxLength() {
    long long start = 1, end = (*max_element(arr, arr + k)) + 1;
    while (start + 1 < end) {
        long long mid = (start + end) / 2;
        if (check(mid)) start = mid;
        else end = mid;
    }
    return start;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> k >> n;
    for (int i = 0; i < k; i++) cin >> arr[i];
    cout << findMaxLength(); // 1: true, max + 1: false;
}