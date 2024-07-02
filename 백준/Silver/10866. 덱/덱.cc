#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    deque<int> deq;
    int n, x;
    string inst;
    cin >> n;
    while (n--) {
        cin >> inst;
        if (inst == "push_front") {
            cin >> x;
            deq.emplace_front(x);
        } else if (inst == "push_back") {
            cin >> x;
            deq.emplace_back(x);
        } else if (inst == "pop_front") {
            if (deq.size()) {
                cout << deq.front() << '\n';
                deq.pop_front();
            } else {
                cout << -1 << '\n';
            }
        } else if (inst == "pop_back") {
            if (deq.size()) {
                cout << deq.back() << '\n';
                deq.pop_back();
            } else {
                cout << -1 << '\n';
            }
        } else if (inst == "size") {
            cout << deq.size() << '\n';
        } else if (inst == "empty") {
            cout << deq.empty() << '\n';
        } else if (inst == "front") {
            if (deq.size()) {
                cout << deq.front() << '\n';
            } else {
                cout << -1 << '\n';
            }
        } else {
            if (deq.size()) {
                cout << deq.back() << '\n';
            } else {
                cout << -1 << '\n';
            }
        }
    }
}