#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, tmp = 0, result = 0;
    bool open = false;
    char opt;
    cin >> n;
    result += n;
    while (cin >> opt) {
        cin >> n;
        if (opt == '-') {
            if (!open) {
                tmp += n;
                open = true;
            } else {
                result -= tmp;
                tmp = n;
            }
        } else {
            if (!open) {
                result += n;
            } else {
                tmp += n;
            }
        }
    }
    if (open) {
        result -= tmp;
    }
    cout << result;
}