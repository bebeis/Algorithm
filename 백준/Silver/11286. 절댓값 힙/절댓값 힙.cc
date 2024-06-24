#include <iostream>
#include <queue>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, x;
    auto compare = [](int a, int b) { 
        int p = abs(a);
        int q = abs(b);
        if (p > q) {
            return true;
        }
        else if (p < q) {
            return false;
        }
        else {
            return a > b;
        }
    };
    priority_queue<int, std::vector<int>, decltype(compare)> absHeap(compare);
    cin >> n;
    while (n--) {
        cin >> x;
        if (x != 0) {
            absHeap.push(x);
        }
        else {
            if (absHeap.empty()) {
                cout << 0 << '\n';
            }
            else {
                cout << absHeap.top() << '\n';
                absHeap.pop();
            }
        }
    }
}