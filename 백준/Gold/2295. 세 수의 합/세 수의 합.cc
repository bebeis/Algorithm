#include <bits/stdc++.h>
using namespace std;

// BruteForce : O(n^4)
// N <= 1000이므로, O(N^3)보다 빨라야 함
// d - c가 a + b에 존재하는지 구하면 --> d - c에서 O(N^2), 탐색 : logn --> O(N^2logn)

int arr[1002];
int n;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    // a + b 쌍 만들기
    vector<int> comb;
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            comb.push_back(arr[i] + arr[j]);
        }
    }
    sort(comb.begin(), comb.end());
    for (int i = n - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (binary_search(comb.begin(), comb.end(), arr[i] - arr[j])) {
                cout << arr[i];
                return 0;
            }
        }
    }
}
