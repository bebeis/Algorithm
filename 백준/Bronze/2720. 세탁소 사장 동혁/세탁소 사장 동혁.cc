#include <iostream>
using namespace std;

int main(void) {
    int n, change;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> change;
        cout << change / 25 << " ";
        change = change % 25;
        cout << change / 10 << " ";
        change = change % 10;
        cout << change / 5 << " ";
        cout <<  change % 5 << '\n';
    }
}