#include <iostream>
using namespace std;

int main(void) {
    string input;
    cin >> input;
    int idx;
    string after[8] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    for (int i = 0; i < 8; i++) {
        while (input.find(after[i]) != string::npos) {
            if (after[i].length() == 2) {
                input.replace(input.find(after[i]), 2, "*");
            }
            else if (after[i].length() == 3) {
                input.replace(input.find(after[i]), 3, "*");
            }
        }
    }
    cout << input.length();
}