#include <bits/stdc++.h>
using namespace std;

// 괄호 문제로 치환해서 풀면 될 듯?
// 자료구조 문제 -> 상태를 어떻게 유지할거냐.

int cnt = 0;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    bool aclose = false; bool bclose = false;
    int n; cin >> n;
    while (n--) {
        string str; cin >> str;
        stack<char> S;
        for (char c : str) {
            if (S.empty()) {
                S.push(c);
                continue;
            } else if (S.top() == c) {
                S.pop();
                continue;
            } else {
                S.push(c);
            }
        }
        if (S.empty()) cnt++;
    }
    cout << cnt;
}