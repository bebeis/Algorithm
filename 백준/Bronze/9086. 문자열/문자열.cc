#include <iostream>
#include <string>
using namespace std;

int main(void) {
    int n;
    cin >> n;
    string input;
    for (int i = 0; i < n; i++) {
        fflush(stdin);
        cin >> input;
        cout << input.front() << input.back() << '\n';
    }
}