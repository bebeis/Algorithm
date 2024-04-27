#include <iostream>
using namespace std;
typedef long long int lli;

lli factorial(lli x) {
    if (x <= 1) {
        return 1;
    }
    else {
        return x * factorial(x - 1);
    }
}

int main(void) {
    lli n;
    cin >> n;
    cout << factorial(n);
}