#include <iostream>
#include <algorithm>
using namespace std;

// 최대공약수를 구하는 함수 (유클리드 호제법 이용)
int gcd(int a, int b) {
	int r = a % b;
	if (r == 0) {
		return b;
	}
	else {
		return gcd(b, r);
	}
	
}

int main(void) {
    int t, a, b;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> a >> b;
        cout << a * b / gcd(a, b) << '\n';
    }
}