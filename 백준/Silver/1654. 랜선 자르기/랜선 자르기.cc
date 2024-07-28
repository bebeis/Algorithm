#include <bits/stdc++.h>
using namespace std;

// brute force : O(KN) : 최대 10 000 000 000 --> TLE
// 이분 분할을 통해 O(KlogN)으로 줄일 수 있음

int k, n;
vector<int> input;

long long getLength(long long min, long long max) {
    if (min > max) return max;
    long long mid = (min + max) / 2;
    int cnt = 0;
    for (auto x : input) {
        cnt += x / mid;
    }
    if (cnt < n) return getLength(min, mid - 1);
    else return getLength(mid + 1, max);
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int max = -1;
    cin >> k >> n;
    input.resize(k);
    for (int i = 0; i < k; i++) {
        cin >> input[i];
        if (input[i] > max) max = input[i];
    }
    cout << getLength(1, max);
}