#include <bits/stdc++.h>
using namespace std;

struct median {
    priority_queue<int, vector<int>> maxHeap; // 최대 힙
    priority_queue<int, vector<int>, greater<int>> minHeap; // 최소 힙
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
        } else {
            return maxHeap.top();
        }
    }
};

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, val;
    median midHeap;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> val;
        midHeap.insert(val);
        cout << midHeap.getMedian() << '\n';
    }
}