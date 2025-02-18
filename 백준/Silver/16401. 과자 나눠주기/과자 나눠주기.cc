#include <bits/stdc++.h>
using namespace std;

int m, n;
int arr[1000003];

/**
 * 모든 조카에게 같은 길이X
 * 3명
 * 1 1 이면 1짜리 2개로 불가능하다.
 */
bool check(int length) {
    if (length == 0) return true;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i] / length;
    }
    if (sum >= m) return true;
    else return false;
}

int findMaxLength() {
    int start = 0; // check(0) = true;
    int end = (*max_element(arr, arr + n)) + 1; // check(max + 1) = false;
    while (start + 1 < end) {
        int mid = (start + end) / 2;
        if (check(mid)) start = mid;
        else end = mid;
    }
    return start;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> m >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    cout << findMaxLength();

}