#include <bits/stdc++.h>
using namespace std;

int arr[51];
int sum = 0;
char op[51];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> arr[0];
    sum = arr[0];
    int idx = 0;
    bool minus = false;
    while (cin >> op[++idx]) {
        cin >> arr[idx];
        if (op[idx] == '-') minus = true;
        if (minus) sum -= arr[idx];
        else sum += arr[idx];
    }
    cout << sum;
}