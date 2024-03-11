#include <iostream>
using namespace std;

int main(void) {
    cin.tie(NULL);
    cin.sync_with_stdio(false);
    int size, temp;
    int min = 1000000, max = -1000000;
    cin >> size;
    while(size--) {
        cin >> temp;
        if (temp < min) {
            min = temp;
        }
        if (temp > max) {
            max = temp;
        }
    }
    cout << min << " " << max;
}