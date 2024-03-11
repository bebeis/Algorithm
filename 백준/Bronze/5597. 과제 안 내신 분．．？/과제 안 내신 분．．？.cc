#include <iostream>
using namespace std;

int main(void) {
    int att_arr[30] = { 0, };
    int stu_number;
    for (int i = 0; i < 28; i++) {
        cin >> stu_number;
        att_arr[stu_number - 1] = 1;
    }
    for (int i = 0; i < 30; i++) {
        if (att_arr[i] != 1) {
            cout << i + 1 << '\n';
        }
    }
}