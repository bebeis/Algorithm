#include <iostream>
#include <algorithm>
using namespace std;

int binarySearch(int arr[], int target, int start, int end) {
    if (start > end) {
        return 0;
    }
    int mid = (start + end) / 2;
    if (target == arr[mid]) {
        return 1;
    }
    else if (target > arr[mid]) {
        return binarySearch(arr, target, mid + 1, end);
    }
    else {
        return binarySearch(arr, target, start, mid - 1);
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m, temp;
    cin >> n;
    int *arr = new int[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> temp;
        cout << binarySearch(arr, temp, 0, n - 1) << '\n';
    }
}