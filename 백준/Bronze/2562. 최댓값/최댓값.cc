#include <iostream>
using namespace std;

int main(void) {
    cin.tie(NULL);
    cin.sync_with_stdio(false);
    int idx, temp, max = 0;
    for (int i = 0; i < 9; i++) {
        cin >> temp;
        if (temp > max) {
            idx = i;
            max = temp;
        }
    }
    cout << max << '\n';
    cout << idx + 1;
}