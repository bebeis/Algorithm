#include <iostream>
using namespace std;

int main(void) {
    int n, total = 0;
    string input;
    cin >> n;
    cin >> input;
    for (char c : input) {
        total += c - '0';
    }
    cout << total;
}