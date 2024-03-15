#include <iostream>
#include <algorithm>
using namespace std;

int commonDivisor(int a, int b) {
    int min = std::min(a, b);
    int commonDivisor;
    for (int i = 1; i <= min; i++) {
        if ((a % i == 0) && (b % i == 0)) {
            commonDivisor = i;
        }
    }
    return commonDivisor;
}

int main(void) {
    int t, a, b;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> a >> b;
        cout << a * b / commonDivisor(a, b) << '\n';
    }
}