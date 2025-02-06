#include <bits/stdc++.h>
using namespace std;

int n, s;
int arr[22];
int cnt = 0;

void partSum(int sum, int cur) {
    if (cur >= n) return;
    if (sum + arr[cur] == s) {
        cnt++;
    }
    partSum(sum + arr[cur], cur + 1);
    partSum(sum, cur + 1);
}


int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n >> s;
    for (int i = 0; i < n; i++) cin >> arr[i];
    partSum(0, 0);
    cout << cnt;
}