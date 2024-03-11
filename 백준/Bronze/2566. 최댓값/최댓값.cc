#include <iostream>
using namespace std;

int main(void) {
    int matrix[9][9];
    int max_row = 0;
    int max_col = 0;
    int max_value = 0;
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            cin >> matrix[i][j];
        }
    }
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (matrix[i][j] > max_value) {
                max_value = matrix[i][j];
                max_row = i;
                max_col = j;
            }
        }
    }
    cout << max_value << '\n';
    cout << max_row + 1 << " " << max_col + 1;
}