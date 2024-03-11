#include <iostream>
using namespace std;

int digitSum(int x) {
    int result = 0;
    while (x != 0) {
        result += x % 10;
        x /= 10;
    }
    return result;
}

int disassemble(int start, int end) {
    while (start < end) {
        if ((start + digitSum(start)) == end) {
            return start;
        }
        else {
            start++;
        }
    }
    return 0;
}

int main(void) {
    int n;
    cin >> n;
    if (n > 54) {
        cout << disassemble(n - 54, n);
    }
    else {
        cout << disassemble(1, n);
    }
}