#include <iostream>
#include <queue>

using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, x;
    priority_queue<int> max_heap;
    cin >> n;
    while (n--) {
        cin >> x;
        if (x > 0) {
            max_heap.push(x);
        }
        else {
            if (max_heap.empty()) {
                cout << 0 << '\n';
            }
            else {
                cout << max_heap.top() << '\n';
                max_heap.pop();
            }
        }
    }
}