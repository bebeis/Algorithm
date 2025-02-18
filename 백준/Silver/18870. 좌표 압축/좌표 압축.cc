#include <bits/stdc++.h>
using namespace std;

int arr[1000002];
int sorted_arr[1000002];
int set_arr[1000002];
int n;

// -10, -9, 2, 4, 4
// 서로 다른 좌표 Xj의 개수

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    memcpy(sorted_arr, arr, sizeof(int) * n);
    sort(sorted_arr, sorted_arr + n);
    set_arr[0] = sorted_arr[0];
    int idx = 0;
    for (int i = 1; i < n; i++) {
        if (set_arr[idx] != sorted_arr[i]) set_arr[++idx] = sorted_arr[i];
    }

    for (int i = 0; i < n; i++) {
        cout << lower_bound(set_arr, set_arr + idx, arr[i]) - set_arr << ' ';
    }
}