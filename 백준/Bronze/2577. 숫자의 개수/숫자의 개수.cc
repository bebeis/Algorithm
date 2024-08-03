#include <bits/stdc++.h>
using namespace std;

int arr[10];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int a, b, c;
    int result;
    cin >> a >> b >> c;
    result = a * b * c;
    while (result != 0) {
        arr[result % 10] += 1;
        result /= 10;
    }
    for (auto x : arr) {
        cout << x << '\n';
    }
}