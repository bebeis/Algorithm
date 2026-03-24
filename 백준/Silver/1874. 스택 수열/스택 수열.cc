#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);

    stack<int> stack;
    int cur = 1, n, popped;
    cin >> n;
    string ans;

    for (int i = 0; i < n; i++) {
        cin >> popped;

        while (stack.empty() || stack.top() < popped) {
            stack.push(cur++);
            ans += "+\n";
        }

        if (stack.top() != popped) {
            cout << "NO";
            return 0;
        }
        stack.pop();
        ans += "-\n";
    }
    cout << ans;
}
