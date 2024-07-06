#include <bits/stdc++.h>
using namespace std;

// 메모리 제한 : 12MB
// 1억개 : 400MB, 2,250,000 크기 배열 : 8MB? --> counting sort 하지 말라는 뜻
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    vector<int> array(n * n);
    for (int i = 0; i < n * n; i++) {
        cin >> array[i];
    }
    make_heap(array.begin(), array.end());
    priority_queue<int, vector<int>> maxHeap(std::less<int>(), std::move(array));
    for (int i = 0; i < n - 1; i++) {
        maxHeap.pop();
    }
    cout << maxHeap.top();
}