#include <iostream>
using namespace std;

// 0번째 shell : 1 : 1개
// 1번째 shell : 2~7 : 6개 : a1 = 6*1 + a0
// 2번째 shell : 8~19 : 12개 : a2 = 6*2 + a1
// 3번째 shell : 20~37 : 18개 : a3 = 6*3 + a2
//                          : an = 6*n + a(n-1)
// an - a0 = 6*1 + 6*2 + .... 6*n
int main(void) {
    int n, shell = -1, boundary = 1;
    cin >> n;
    while (n > boundary) {
        shell++;
        boundary = 6 * shell + boundary;
    }
    if (n == 1) {
        shell = 0;
    }
    cout << shell + 1;
}