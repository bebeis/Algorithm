#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int x; char c;
    cin >> x;
    int sum = x;
    bool minus = false;
    while (cin >> c) {
        cin >> x;
        if (c == '-') minus = true;
        if (minus) sum -= x;
        else sum += x;
    }
    cout << sum;
}