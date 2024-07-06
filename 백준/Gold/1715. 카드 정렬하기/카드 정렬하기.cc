#include <bits/stdc++.h>
using namespace std;

int main(void) {
    // subset중 매 단계에서 가장 작은거 2개를 더해야 한다.
    // 매번 pop을 하고 sorting하면 N^2log(n)으로 비효율적
    // 힙을 이용하는게 좋을듯
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, x, y, sum = 0;
    cin >> n;
    vector<int> array(n);
    for (int i = 0; i < n; i++) {
        cin >> array[i];
    }
    make_heap(array.begin(), array.end(), greater<int>()); // O(N), heapify
    priority_queue<int, vector<int>, greater<int>> minHeap(std::greater<int>(), std::move(array)); // O(N)
    for (int i = 0; i < n - 1; i++) {
        x = minHeap.top();
        minHeap.pop();
        y = minHeap.top();
        minHeap.pop();
        minHeap.push(x + y);
        sum += x + y;
    }
    cout << sum;
}