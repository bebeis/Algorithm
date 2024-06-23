#include <iostream>
#include <queue>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, x;
    priority_queue<int, vector<int>, greater<int>> min_heap;
    cin >> n;
    while (n--) {
        cin >> x;
        if (x > 0) {
            min_heap.push(x);
        }
        else {
            if (min_heap.empty()) {
                cout << 0 << '\n';
            }
            else {
                cout << min_heap.top() << '\n';
                min_heap.pop();
            }
        }
    }
}
