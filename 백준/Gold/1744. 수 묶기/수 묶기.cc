#include <bits/stdc++.h>
using namespace std;

int arr[52];
int sum = 0;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    int i = 0, j = i + 1;
    // {음수, 음수}, 
    while (i < n && arr[i] <= 0) {
        if (j == n) {
            sum += arr[i];
            break;
        }
        else if (arr[j] <= 0) {
            sum += arr[i] * arr[j];
            i += 2; j += 2;
        } else { // 음수, 양수
            sum += arr[i];
            break;
        }
    }
    j = n - 1; i = j - 1;
    while (j >= 0 && arr[j] > 0) {
        if (i < 0) {
            sum += arr[j];
            break;
        }
        else if (arr[i] > 0) {
            if (arr[i] * arr[j] > arr[i] + arr[j]) {
                sum += arr[i] * arr[j];
            } else {
                sum += arr[i] + arr[j];
            }
            i -= 2; j -= 2;
        } else {
            sum += arr[j];
            break;
        }
    }
    cout << sum;

    // 양수, 양수 : 곱하기
    // 0, 양수 : 각자 더하기
    // 0, 0 : do nothing
    // 음수, 양수 : 각자 더하기
    // 음수, 0 : 곱하기
    // 음수, 음수 : 곱하기
    // -3 -2 -1 0 1 2 3
}