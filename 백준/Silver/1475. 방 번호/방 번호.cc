#include <bits/stdc++.h>
using namespace std;

int cnt[10];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    string input;
    int x, max;
    cin >> input;
    for (char x : input) {
        cnt[x - 48]++;
    }
    max = 0;
    for (int i = 0; i < 10; i++) {
        if (i == 6 || i == 9) {
            continue;
        }
        else {
            if (cnt[i] > max) {
                max = cnt[i];
            }
        }
    }
    x = (cnt[6] + cnt[9]) / 2 + (cnt[6] + cnt[9]) % 2;
    if (x > max) {
        max = x;
    }
    cout << max;
}