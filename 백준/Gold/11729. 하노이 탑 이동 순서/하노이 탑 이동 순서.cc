#include <bits/stdc++.h>
using namespace std;

// 1 ~ N을 완성하기 위해서는, 1 ~ N - 1이 완성되어야 한다.
// -> 재귀 느낌이 난다.
// 재귀에서 상태 -> 파라미터화
// 상태 : N - 1, 어디서부터, 어디로
// n <= 20, O(2^n)은 가능

// 틀린 이유: 총 이동횟수 안구해서 틀림;

int n;

// k - 1번이 x에서 y로 움직이고, 바닥이 움직이고, 다시 4번이 y에서 z로움직인다.
void hanoi(int k, int from, int to) { 
	if (k == 0) return;
	int middle = 6 - from - to;
	hanoi(k - 1, from, middle);
	cout << from << " " << to << '\n';
	hanoi(k - 1, middle, to);
}


int main(void) {
	cin.tie(0)->sync_with_stdio(false);
	cin >> n;
    cout << (1 << n) - 1 << '\n';
	hanoi(n, 1, 3);
}