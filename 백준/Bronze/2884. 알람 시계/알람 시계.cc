#include <iostream>
using namespace std;

int main(void) {
    int h, m;
    cin >> h >> m;
    if (m < 45) {
        if (h == 0) {
            cout << "23 " << 15 + m;
        } else {
            cout << h - 1 << " " << 15 + m;
        }
    } else {
        cout << h << " " << m - 45;
    }
}