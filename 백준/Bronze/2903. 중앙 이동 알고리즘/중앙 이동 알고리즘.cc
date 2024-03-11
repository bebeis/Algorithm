#include <iostream>
using namespace std;

int pow(int x, int n) { // pow 함수 직접 구현
    int result = 1;
    if (n == 0) {
        return result;
    }
    else {
        while (n > 0) {
            result *= x;
            n--;
        }
        return result;
    }
    return -1;
}

int main(void) {
    /*
    변의 길이 : 1 -> 2 -> 4 -> 8 -> .... 2^(n)
    변의 길이가 k일 때 변에 있는 점의 개수 : 2^(n) + 1
    총 점의 개수 : k ^ 2
    */
    int n, ans;
    cin >> n;
    // 아래의 경우 cmath의 pow 함수를 사용하면 캐스팅 과정에서 정확한 값을 출력하지 못함
    cout << pow((pow(2, n) + 1), 2);
}