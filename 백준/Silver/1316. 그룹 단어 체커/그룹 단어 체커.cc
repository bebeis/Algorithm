#include <iostream>
using namespace std;

int main(void) {
    int n, length, result = 0;
    bool check;
    int alphabet[26];
    cin >> n;
    string *arr = new string[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    for (int i = 0; i < n; i++) {
        for (int k = 0; k < 26; k++) {
            alphabet[k] = 0;
        }
        length = arr[i].length();
        check = true;
        for (int j = 0; j < length - 1; j++) {
            if (arr[i][j] == arr[i][j + 1]) {
                arr[i].replace(j, 2, arr[i].substr(j, 1));
                length--;
                j--;
            }
        }
        for (int m = 0; m < arr[i].length(); m++) {
            alphabet[arr[i][m] - 97]++;
        }
        for (int c : alphabet) {
            if (c > 1) {
                check = false;
            }
        }
        if (check == true) {
            result++;
        }
    }
    cout << result;
}