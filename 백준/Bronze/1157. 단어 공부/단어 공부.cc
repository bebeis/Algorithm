#include <iostream>
using namespace std;

int main(void) {
    string s;
    int arr[26] = { 0, };
    int max = -1, check = 0;
    char res;
    cin >> s;
    for (int i = 0; i < s.length(); i++) {
        s[i] = toupper(s[i]);
        arr[s[i] - 65]++;
    }
    for (int i = 0; i < 26; i++) {
        if (max < arr[i]) {
            max = arr[i];
            res = char(i + 65);
        }
    }
    for (int i = 0; i < 26; i++) {
        if (max == arr[i]) {
            check++;
        }
    }
    if (check == 1) {
        cout << res;
    }
    else {
        cout << "?";
    }
}