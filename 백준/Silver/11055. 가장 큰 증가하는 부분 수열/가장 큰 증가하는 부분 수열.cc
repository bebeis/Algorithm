#include <bits/stdc++.h>
using namespace std;

int a[1001];
int sum[1001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    cin >> a[1];
    sum[1] = a[1];
    for (int i = 2; i <= n; i++) {
        cin >> a[i];
        sum[i] = a[i];
        for (int j = i - 1; j >= 1; j--) {
            if (sum[i] < sum[j] + a[i] && a[j] < a[i]) sum[i] = sum[j] + a[i];
        }
    }
    cout << *max_element(sum + 1, sum + n + 1);
}