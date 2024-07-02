#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    stack<int> stack;
    int n, val;
    string inst;
    cin >> n;
    while (n--) {
        cin >> inst;
        if (inst == "push") {
            cin >> val;
            stack.emplace(val);
        }
        else if (inst == "top") {
            if (stack.size()) {
                cout << stack.top() << '\n';
            }
            else {
                cout << -1 << '\n';
            }
        }
        else if (inst == "pop") {
            if (stack.size()) {
                cout << stack.top() << '\n';
                stack.pop();
            }
            else {
                cout << -1 << '\n';
            }
        }
        else if (inst == "size") {
            cout << stack.size() << '\n';
        }
        else if (inst == "empty") {
            int a = 1;
            if (stack.size()) {
                a = 0;
            }
            cout << a << '\n';
        }
    }
}