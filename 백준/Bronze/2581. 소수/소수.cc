#include <iostream>
using namespace std;

bool is_prime(int x) {
    if (x == 1) {
        return false;
    }
    int i = 1;
    while (x > ++i) {
        if (x % i == 0) {
            return false;
        }
    }
    return true;
}

int main(void) {
    int m, n, sum = 0, min = -1;
    cin >> m >> n;
    while (n >= m) {
        if (is_prime(n)) {
            sum += n;
            min = n;
        }
        n--;
    }
    if (min == -1) {
        cout << -1;
    }
    else {
        cout << sum << '\n';
        cout << min;
    }
}