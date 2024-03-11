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
    int n, x, prime_count = 0;
    cin >> n;
    while (n--) {
        cin >> x;
        if (is_prime(x)) {
            prime_count++;
        }
    }
    cout << prime_count;
}