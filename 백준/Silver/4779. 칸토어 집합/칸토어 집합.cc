#include <iostream>
#include <cmath>
using namespace std;

void kantour(string &subset, int p, int q) {
    if (p >= q) {
        return;
    }
    int x = (q - p + 1) / 3;
    for (int i = p + x; i < p + 2 * x; i++) {
        subset[i] = ' ';
    }
    kantour(subset, p, p + x - 1);
    kantour(subset, p + 2 * x, q);
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    string set;
    while (cin >> n) {
        set.assign(pow(3, n), '-');
        kantour(set, 0, set.length() - 1);
        cout << set << '\n';
    }
}