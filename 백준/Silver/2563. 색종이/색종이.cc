#include <iostream>
using namespace std;

int area[100][100];

int main(void) {
    int n, result = 0;
    cin >> n;
    int x, y;
    for (int k = 0; k < n; k++) {
        cin >> x >> y;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                area[y + i][x + j] = 1;
            }
        }
    }
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            result += area[i][j];
        }
    }
    cout << result;
}