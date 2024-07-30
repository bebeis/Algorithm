#include <bits/stdc++.h>
using namespace std;

int arr[500002];
int n;

// 이분 탐색 공부를 위해 lower_bound와 upper_bound 라이브러리 함수를 직접 구현 해봄
int lower_bnd(int target, int len) {
    int low = 0;
    int high = len;
    while (low < high) {
        int mid = (low + high) / 2;
        if (arr[mid] >= target) high = mid;
        else low = mid + 1;
    }
    return low;
}

int upper_bnd(int target, int len) {
    int low = 0;
    int high = len;
    while (low < high) {
        int mid = (low + high) / 2;
        if (arr[mid] > target) high = mid;
        else low = mid + 1;
    }
    return low;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int m, t;
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    cin >> m;
    while (m--) {
        cin >> t;
        cout << upper_bnd(t, n) - lower_bnd(t, n) << ' ';
    }
}