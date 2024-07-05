#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n, m, val, count = 0;
    cin >> n >> m;
    deque<int> deq(n);
    for (int i = 0; i < n; i++) {
        deq[i] = i + 1;
    }
    while (m--) {
        cin >> val;
        if (val == deq.front()) {
            deq.pop_front();
        } else {
            int pos = find(deq.begin(), deq.end(), val) - deq.begin();
            if (pos <= deq.size() / 2) {
                while (deq.front() != val) {
                    deq.push_back(deq.front());
                    deq.pop_front();
                    count++;
                }
            } else {
                while (deq.front() != val) {
                    deq.push_front(deq.back());
                    deq.pop_back();
                    count++;
                }
            }
            deq.pop_front();
        }
    }
    cout << count;
}
