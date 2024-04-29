#include <iostream>
using namespace std;

int cnt, n, k;

void merge(int arr[], int p, int q, int r) {
    int i = p, j = q + 1, t = 1, temp[r - p + 1];
    while (i <= q && j <= r) {
        if (arr[i] <= arr[j]) {
            temp[t++] = arr[i++];
        }
        else {
            temp[t++] = arr[j++];
        }
    }
    while (i <= q) {
        temp[t++] = arr[i++];
    }
    while (j <= r) {
        temp[t++] = arr[j++];
    }
    i = p; t = 1;
    while (i <= r) {
        if (++cnt == k) {
            cout << temp[t++];
            return;
        }
        arr[i++] = temp[t++];
    }
}

void merge_sort(int arr[], int p, int r) {
    if (p < r) {
        int q = (p + r) / 2;
        merge_sort(arr, p, q);
        merge_sort(arr, q + 1, r);
        merge(arr, p, q, r);
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cnt = 0;
    cin >> n >> k;
    int *arr = new int[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    merge_sort(arr, 0, n - 1);
    if (cnt < k) {
        cout << -1;
    }
}