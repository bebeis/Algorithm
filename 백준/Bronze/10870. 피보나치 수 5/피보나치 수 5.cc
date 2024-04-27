#include <iostream>
using namespace std;

int fibonacci(int x) {
    if (x == 0) {
        return 0;
    }
    else if (x == 1) {
        return 1;
    }
    return fibonacci(x - 1) + fibonacci(x - 2);
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    cout << fibonacci(n);
}