#include <iostream>
using namespace std;

int check_palindrome(string a) {
    int len = a.length();
    for (int i = 0; i < len / 2; i++) {
        if (a[i] != a[len - 1 - i]) {
            return 0;
        }
    }
    return 1;
}

int main(void) {
    string a;
    cin >> a;
    cout << check_palindrome(a);
}