#include <bits/stdc++.h>
using namespace std;

// 길이 <= 5000  --> O(N^2) 이하로 풀면 될 듯
// 1000000으로 나눈 나머지를 출력한다
// 0은 해독이 불가능 함을 주의하자

int d[5001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    string n;
    cin >> n;
    int length = n.length();
    if (n[0] == '0') {
        cout << 0;
        return 0;
    }
    if (length == 1) {
        cout << 1;
        return 0;
    }
    // 기저 조건
    d[0] = 1;
    if (stoi(n.substr(0, 2)) <= 26) {
        if (n[1] == '0') d[1] = 1;
        else d[1] = 2;
    } else {
        if (n[1] == '0') d[1] = 0;
        else d[1] = 1;
    }
    for (int i = 2; i < length; i++) {
        if (n[i] != '0') d[i] = d[i - 1];
        int num = stoi(n.substr(i - 1, 2));
        if (num <= 26 && num >= 10) d[i] = (d[i] + d[i - 2]) % 1000000;
    }
    cout << d[n.length() - 1];
}