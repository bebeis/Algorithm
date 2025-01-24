#include <bits/stdc++.h>
using namespace std;

int result[1000001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int n; cin >> n;
    stack<pair<int, int>> S;
    for (int i = 1; i <= n; i++) {
        int x; cin >> x;
        while (!S.empty() && S.top().second < x) {
            result[S.top().first] = x;
            S.pop();
        }
        S.push({i, x});
    }

    while (!S.empty()) {
        result[S.top().first] = -1;
        S.pop();
    }

    for (int i = 1; i <= n; i++) cout << result[i] << ' ';
}