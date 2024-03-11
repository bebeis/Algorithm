#include <iostream>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n, i = 2;
    cin >> n;
    while (n > 1) {
        if (n % i == 0) {
            cout << i << '\n';
            n /= i;
        }
        else {
            i++;
        }
    }
}