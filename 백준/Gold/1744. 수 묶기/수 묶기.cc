#include <bits/stdc++.h>
using namespace std;

// 양수 배열은 큰 것 부터 순회, 음수 배열은 작은 것 부터 순회한다.
// 주의! 음수 X 음수(0포함)를 고려해야한다.

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
    int n, val, sum = 0;
    cin >> n;
    priority_queue<int, vector<int>, greater<int>> npq;
    priority_queue<int, vector<int>, less<int>> ppq;
    for (int i = 0; i < n; i++) {
        cin >> val;
        if (val <= 0) npq.push(val);
        else ppq.push(val);
    }
    while (npq.size() >= 2) {
        auto x1 = npq.top(); npq.pop();
        auto x2 = npq.top(); npq.pop();
        sum += x1 * x2;
    }
    if (!npq.empty()) sum += npq.top();

    while (ppq.size() >= 2) {
        auto x1 = ppq.top(); ppq.pop();
        auto x2 = ppq.top(); ppq.pop();
        if (x1 + x2 < x1 * x2) sum += x1 * x2;
        else {
            sum += x1;
            ppq.push(x2);
        }
    }
    if (!ppq.empty()) sum += ppq.top();
    cout << sum;
}