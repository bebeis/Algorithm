#include <bits/stdc++.h>
using namespace std;

string infix;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> infix;
    stack<char> op_stk;
    for (int i = 0; i < infix.length(); i++) {
        if (isupper(infix[i])) {
            cout << infix[i];
        } else if (infix[i] == '(') {
            op_stk.push('(');
        } else if (infix[i] == ')') {
            while (!op_stk.empty() && op_stk.top() != '(') {
                cout << op_stk.top();
                op_stk.pop();
            }
            if (!op_stk.empty() && op_stk.top() == '(') {
                op_stk.pop();
            } else {
                
            }
        } else { // operator
            if (op_stk.empty()) {
                op_stk.push(infix[i]);
                continue;
            }
            if ((infix[i] == '*' || infix[i] == '/')) {
                if (op_stk.top() == '(' || op_stk.top() == '+' || op_stk.top() == '-') {
                    op_stk.push(infix[i]);
                } else {
                    cout << op_stk.top();
                    op_stk.pop();
                    op_stk.push(infix[i]);
                }
            } else {
                if (op_stk.top() == '(') {
                    op_stk.push(infix[i]);
                }
                else if (op_stk.top() == '+' || op_stk.top() == '-') {
                    cout << op_stk.top();
                    op_stk.pop();
                    op_stk.push(infix[i]);
                } else {
                    while (!op_stk.empty() && !(op_stk.top() == '(')) {
                        cout << op_stk.top();
                        op_stk.pop();
                    }
                    op_stk.push(infix[i]);
                }
            }
        }
    }
    while (!op_stk.empty()) {
        cout << op_stk.top();
        op_stk.pop();
    }
}