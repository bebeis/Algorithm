#include <bits/stdc++.h>
using namespace std;

// O(NlogN) 이하로 풀어야 한다.
int n, m;
int arr[1000001];
int psum[1000001];
int mod[1001];

long long cnt = 0;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m >> arr[0];
    psum[0] = arr[0] % m;
    mod[psum[0]]++;
    for (int i = 1; i < n; i++) {
        cin >> arr[i];
        psum[i] = (psum[i - 1] + arr[i]) % m;
        mod[psum[i]]++;
    }
    cnt += mod[0];
    for (int i = 0; i < m; i++) cnt += (long long)mod[i] * (mod[i] - 1) / 2; // 가능한 mod의 최댓값이 10^6 --> int 범위 넘어감
    cout << cnt;
}