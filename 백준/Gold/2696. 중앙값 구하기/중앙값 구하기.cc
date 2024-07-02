#include <bits/stdc++.h>
using namespace std;

struct median {
    priority_queue<int, vector<int>> maxHeap; // 최대 힙
    priority_queue<int, vector<int>, greater<int>> minHeap; // 최소 힙
    // 중앙값보다 작으면 최대 힙으로, 중앙값보다 크면 최소 힙으로 삽입
    void insert(int data) {
        if (maxHeap.empty()) {
            maxHeap.push(data);
            return;
        }

        if (maxHeap.size() > minHeap.size()) {
            if (data >= getMedian()) {
                minHeap.push(data);
            }
            else {
                minHeap.push(maxHeap.top());
                maxHeap.pop();
                maxHeap.push(data);
            }
        } else if (maxHeap.size() == minHeap.size()) {
            if (data >= getMedian()) {
                minHeap.push(data);
            } else {
                maxHeap.push(data);
            }
        } else {
            if (data <= getMedian()) {
                maxHeap.push(data);
            } else {
                maxHeap.push(minHeap.top());
                minHeap.pop();
                minHeap.push(data);
            }
        }

    }
    int getMedian() {
        if (maxHeap.size() < minHeap.size()) {
            return minHeap.top();
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.top();
        } else {
            return (maxHeap.top() + minHeap.top()) / 2;
        }
    }
};

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t, m, val;
    cin >> t;
    while (t--) {
        median medianHeap;
        cin >> m;
        cout << m / 2 + 1 << '\n';
        for (int i = 0; i < m; i++) {
            cin >> val;
            medianHeap.insert(val);
            if (i % 2 == 0) {
                cout << medianHeap.getMedian() << " ";
            }
            if (i == (m - 1) || (i + 2) % 20 == 0) {
                cout << '\n';
            }
        }
    }
}