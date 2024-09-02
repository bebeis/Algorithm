#include <bits/stdc++.h>
using namespace std;

// bool arr[20]; 요런식으로 0과 1로 set을 표현할 수 있다.
// 0과 1--> 비트 마스킹을 이용할 수 있지 않을까?
// 비트 마스킹을 이용한 풀이
// 20칸 배열 대신 숫자 1개로 각 칸을 대신한다
// all과 empty를 O(1) * 20이 아니라 O(1)로 처리할 수 있다.
// 2^20으로 표현하면 되므로 int형 범위에서 처리 가능

int m;
int state;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> m;

    while (m--) {
        string inst;
        int val;
        cin >> inst;
        if (inst == "add") {
            cin >> val;
            state |= (1 << (val - 1));
        } else if (inst == "remove") {
            cin >> val;
            state &= (~(1 << (val - 1)));
        } else if (inst == "check") {
            cin >> val;
            cout << ((state >> (val - 1)) & 1) << '\n'; // state를 옮겨서 1과 연산해야 한다.
        } else if (inst == "toggle") { // ^는 or 연산이 아니다.
            cin >> val;
            state ^= (1 << (val - 1));
        } else if (inst == "all") {
            state = 0xfffff;
        } else { // empty
            state = 0;
        }
    }
}