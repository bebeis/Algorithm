#include <iostream>
using namespace std;

/* 1, 2, 4, 7, 11,  ...
a2 = a1 + 1
a3 = a2 + 2
a4 = a3 + 3
an = an-1 + n-1
an - a1 = 1 + 2 + ... n-1
an = n(n-1) / 2 + 1
여기서 an은 1/n 일때 몇 번째 인지
*/ 

int main(void) {
    int n, length, ai = 1, i = 1;
    cin >> n;
    while (n >= ai) {
        ai = ai + i;
        i++;
    }
    i--;
    ai = ai - i;
    length = n - ai;
    if (i % 2 == 0) {
        cout << 1 + length << "/" << i - length;
    }
    else {
        cout << i - length << "/" << 1 + length;
    }
}