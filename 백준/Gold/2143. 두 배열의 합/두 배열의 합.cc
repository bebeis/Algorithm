#include <bits/stdc++.h>
using namespace std;

// T의 범위인 10억 단위에 대해 절대 순회 불가능
// 경우의 수를 저장하려면 map에 저장해야 함.

int t, n, m;
int a[1001];
int b[1001];
long long result = 0;
unordered_map<int, int> um_a;
unordered_map<int, int> um_b;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> t >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    cin >> m;
    for (int i = 0; i < m; i++) cin >> b[i];
    for (int i = 0; i < n; i++) {
        int sum_a = a[i];
        if (um_a.find(sum_a) == um_a.end()) um_a[sum_a] = 0;
        um_a[sum_a] += 1;
        for (int j = i + 1; j < n; j++) {
            sum_a += a[j];
            if (um_a.find(sum_a) == um_a.end()) um_a[sum_a] = 0;
            um_a[sum_a] += 1;
        }
    }
    for (int i = 0; i < m; i++) {
        int sum_b = b[i];
        if (um_b.find(sum_b) == um_b.end()) um_b[sum_b] = 0;
        um_b[sum_b] += 1;
        for (int j = i + 1; j < m; j++) {
            sum_b += b[j];
            if (um_b.find(sum_b) == um_b.end()) um_b[sum_b] = 0;
            um_b[sum_b] += 1;
        }
    }

    for (auto x : um_a) {
        if (um_b.contains(t - x.first)) result += (long long)x.second * um_b[t - x.first];
    }

    cout << result;
}