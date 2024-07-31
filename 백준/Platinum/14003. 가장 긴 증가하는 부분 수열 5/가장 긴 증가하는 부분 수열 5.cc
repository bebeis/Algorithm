#include <bits/stdc++.h>
using namespace std;

// 12015 --> dq 벡터에서 사이즈를 통해 길이를 구할 수 있었다.
// 14003 --> 최대 길이를 가지고 역추적해야 한다
/*
0 1 2 3 4 5 : i
-------------
1 3 4 5 2 6 : arr
0 1 2 3 1 4 : idx_arr

dq_val 1 2 4 5 6
dq_idx 1 2 3 4 5
*/

vector<int> arr;
vector<int> idx_arr;
vector<int> dq;

int binarySearch(int low, int high, int target) {
    while (low < high) {
        int mid = (low + high) / 2;
        if (dq[mid] < target) low = mid + 1;
        else high = mid;
    }
    return low;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    arr.resize(n); idx_arr.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    dq.push_back(arr[0]);
    idx_arr[0] = 0;
    for (int i = 1; i < n; i++) {
        if (dq.back() < arr[i]) {
            // 맨 뒤에 삽입하므로
            idx_arr[i] = dq.size();
            dq.push_back(arr[i]);
        }
        else {
            int idx = binarySearch(0, dq.size() - 1, arr[i]);
            dq[idx] = arr[i];
            idx_arr[i] = idx;
        }
    }
    int j = dq.size();
    cout << j << '\n';
    int max_idx = distance(idx_arr.begin(), max_element(idx_arr.begin(), idx_arr.end()));
    while (j > 0) {
        if (idx_arr[max_idx] + 1 == j) {
            j--;
            dq[j] = arr[max_idx];
        }
        max_idx--;
    }
    for (auto x : dq) {
        cout << x << " ";
    }
}
