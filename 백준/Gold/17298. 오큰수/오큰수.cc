#include <bits/stdc++.h>
using namespace std;

// time limit : 1s, N <= 1,000,000 : O(NlogN) 이하로 해결

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, val;
    cin >> n;
    stack<pair<int, int>> a; // {index, value}
    vector<int> output(n, -1);
    for (int i = 0; i < n; i++) {
        cin >> val;
        while (!a.empty() && a.top().second < val) {
            output[a.top().first] = val;
            a.pop();
        }
        a.push({i, val});
    }
    for (int &x : output) {
        cout << x << " ";
    }
}