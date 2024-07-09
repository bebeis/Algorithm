#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, sum = 0;
    cin >> n;
    vector<int> array(n);
    for (int i = 0; i < n; i++) {
        cin >> array[i];
        sum += array[i];
    }
    sort(array.begin(), array.end(), greater<int>());
    for (int i = 1; i < n; i++) {
        sum += array[i] * i;
    }
    cout << sum;
}