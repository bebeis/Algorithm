#include <bits/stdc++.h>
using namespace std;

// time limit 1.5s , scope <= 500,000 --> O(N) 이하
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, val;
    stack<pair<int, int>> building;
    stack<pair<int, int>> buffer;
    cin >> n;
    vector<int> output(n);
    // O(N)
    for (int i = 0; i < n; i++) {
        cin >> val;
        building.push({val, i});
    }
    // O(N)
    for (int i = n - 1; i >= 0; i--) {
        if (buffer.empty()) {
            buffer.push(building.top());
            building.pop();
        } else if (buffer.top() < building.top()) {
            while (buffer.top() < building.top()) {
                output[buffer.top().second] = building.top().second + 1;
                buffer.pop();
                if (buffer.empty()) {
                    break;
                }
            }
            buffer.push(building.top());
            building.pop();
        } else { // building.top() > building.top()
            buffer.push(building.top());
            building.pop();
        }
    }
    for (int i = 0; i < buffer.size(); i++) {
        output[buffer.top().second] = 0;
    }
    for (int &x : output) {
        cout << x << " ";
    }
}