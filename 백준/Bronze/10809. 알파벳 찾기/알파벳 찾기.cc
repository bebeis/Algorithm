#include <iostream>
#include <algorithm>
using namespace std;

int main(void) {
    int arr[26], n;
    std::fill(arr, arr + 26, -1);
    string input;
    cin >> input;
    for (int i = 0; i < input.length(); i++) {
        n = input[i] - 97;
        if (arr[n] == -1) {
            arr[n] = i;
        }
    }
    for (int i : arr) {
        cout << i << " ";
    }
}