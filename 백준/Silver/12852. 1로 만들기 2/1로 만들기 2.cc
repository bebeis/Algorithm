#include <bits/stdc++.h>
using namespace std;

int d[1000001];
int pre[1000001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    // tabulation을 이용 --> for문 또는 while문으로 논리 구현
    for (int i = 2; i <= n; i++) {
        d[i] = d[i - 1] + 1;
        pre[i] = i - 1;
        if (i % 3 == 0) {
            int val = d[i / 3] + 1;
            if (d[i] > val) {
                d[i] = val; 
                pre[i] = i / 3;
            }
        }
        if (i % 2 == 0){
            int val = d[i / 2] + 1;
            if (d[i] > val) {
                d[i] = val;
                pre[i] = i / 2;
            }
        }
    }
    cout << d[n] << '\n';
    int k = n;
    while (k != 1) {
        cout << k << " ";
        k = pre[k];
    }
    cout << 1;
}