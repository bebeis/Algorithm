#include <iostream>
#include <cmath>
using namespace std;

// 루프를 돌려서 직접 올라간 횟수를 count 하는 방법 -> 시간 초과
// case에 따른 식을 미리 계산하여 실행 시간을 단축해보자
// 높이가 V 일때, V - a ~ V - 1의 위치에서 올라왔을거임
// (a - b) * (day - 1) + a >= V 를 만족하는 최소 day
// day - 1 >= (V - a) / (a - b)
// day >= (V - a) / (a - b) + 1
int main(void) {
    int a, b, v, day, temp;
    cin >> a >> b >> v;
    day = (v - a) / (a - b) + 1;
    if ((v - a) % (a - b) != 0) {
        day++;
    }
    cout << day;
}