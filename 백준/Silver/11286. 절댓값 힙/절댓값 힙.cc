#include <bits/stdc++.h>
using namespace std;

struct compare {
    bool operator()(int x, int y) {
        if (abs(x) == abs(y)) return x > y;
        return abs(x) > abs(y);
    }
};


int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int n; cin >> n;
    priority_queue<int, vector<int>, compare> pq;
    while (n--) {
        int x; cin >> x;
        if (x != 0) pq.push(x);
        else if (pq.empty()) {
            cout << "0\n";
        } else {
            cout << pq.top() << '\n';
            pq.pop();
        }
    }
}