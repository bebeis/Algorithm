#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    stack<char> bracket;
    string input;
    cin >> input;
    int answer = 0;
    int tmp = 1;
    for (int i = 0; i < input.size(); i++) {
        char c = input[i];
        if (c == '(') {
            bracket.push(c);
            tmp *= 2;
        } else if (c == '[') {
            bracket.push(c);
            tmp *= 3;
        } else if (c == ')') {
            if (bracket.empty() || bracket.top() == '[') {
                cout << 0;
                return 0;
            }
            if (input[i - 1] == '(') {
                answer += tmp;
            }
            tmp /= 2;
            bracket.pop();
        } else { // ']'
            if (bracket.empty() || bracket.top() == '(') {
                cout << 0;
                return 0;
            }
            if (input[i - 1] == '[') {
                answer += tmp;
            }
            tmp /= 3;
            bracket.pop();
        }
    }
    if (bracket.size()) {
        cout << 0;
        return 0;
    }
    cout << answer;
}
