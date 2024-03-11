#include <iostream>
using namespace std;

int main(void) {
    int n, score, max_score;
    double total_score = 0;
    cin >> n;
    int *arr = new int[n];
    for (int i = 0; i < n; i++) {
        cin >> score;
        arr[i] = score;
    }
    max_score = arr[0];
    for (int i = 1; i < n; i++) {
        max_score = max(max_score, arr[i]);
    }
    for (int i = 0; i < n; i++) {
        total_score += arr[i];
    }
    cout << fixed;
    cout.precision(3);
    cout << (((total_score / n) * 100) / max_score);
}