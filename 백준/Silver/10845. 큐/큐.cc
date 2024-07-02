#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    queue<int> que;
    int n, val;
    string inst;
    cin >> n;
    while (n--) {
        cin >> inst;
        if (inst == "push") {
            cin >> val;
            que.emplace(val);
        } else if (inst == "pop") {
            if (que.size()) {
                cout << que.front() << '\n';
                que.pop();
            } else {
                cout << -1 << '\n';
            }
        } else if (inst == "size") {
            cout << que.size() << '\n';
        } else if (inst == "empty") {
            cout << que.empty() << '\n';
        } else if (inst == "front") {
            if (que.size()) {
                cout << que.front() << '\n';
            } else {
                cout << -1 << '\n';
            }
        } else {
            if (que.size()) {
                cout << que.back() << '\n';
            } else {
                cout << -1 << '\n';
            }
        }
    }
}