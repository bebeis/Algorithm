#include <bits/stdc++.h>
using namespace std;

int arr[100001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, pos = 1, cur = 0;
    stringstream ss;
    cin >> n;
    stack<int> buf;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }
    while (pos <= n) {
        if (buf.empty()) {
            buf.push(++cur);
            ss << "+" << '\n';
        } else if (buf.top() < arr[pos]) {
            buf.push(++cur);
            ss << "+" << '\n';
        } else if (buf.top() == arr[pos]) {
            ss << "-" << '\n';
            buf.pop();
            pos++;
        } else { // buf.top() > arr[pos]
            cout << "NO";
            return 0;
        }
    }
    cout << ss.str();
}