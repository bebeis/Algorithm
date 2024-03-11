#include <iostream>
using namespace std;

int main(void) {
    int n, k;
    string input;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> k >> input;
        for (char c : input) {
            for (int j = 0; j < k; j++) {
                cout << c;
            }
        }
        cout << '\n';
    }
}