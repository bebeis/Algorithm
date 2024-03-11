#include <iostream>
using namespace std;

int main(void) {
    int matrixA[100][100];
    int matrixB[100][100];
    int rows, cols;
    cin >> rows >> cols;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cin >> matrixA[i][j];
        }
    }
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cin >> matrixB[i][j];
        }
    }
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cout << matrixA[i][j] + matrixB[i][j] << " ";
        }
        cout << '\n';
    }
}