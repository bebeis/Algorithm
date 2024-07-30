#include <bits/stdc++.h>
using namespace std;

vector<int> arr;
vector<int> dq;

int binarySearch(int low, int high, int target) {
    while (low < high) {
        int mid = (low + high) / 2;
        if (dq[mid] < target) low = mid + 1;
        else high = mid;
    }
    return low;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    arr.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    dq.push_back(arr[0]);
    for (int i = 1; i < n; i++) {
        if (dq.back() < arr[i]) dq.push_back(arr[i]);
        else dq[binarySearch(0, dq.size() - 1, arr[i])] = arr[i];
    }
    cout << dq.size();
}
