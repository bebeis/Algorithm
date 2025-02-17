#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int n; cin >> n;
    int two = 0, five = 0;
    for (int i = 1; i <= n; i++) {
        int k = i;
        while (k % 2 == 0) {
            k /= 2;
            two++;
        }
        while (k % 5 == 0) {
            k /= 5;
            five++;
        }
    }
    cout << min(two, five);
}