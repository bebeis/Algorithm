#include <iostream>
using namespace std;

int main(void) {
    int n, k, i = 0, j = 0;
    cin >> n >> k;
    while (k != j) {
        if (++i > n) {
            i = 0;
            break;
        }
        if (n % i == 0) {
            j++;
        }
    }
    cout << i; 
}