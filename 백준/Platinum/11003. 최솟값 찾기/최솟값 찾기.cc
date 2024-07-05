#include <bits/stdc++.h>
using namespace std;

// 1 <= L <= N <= 500만 --> 못해도 O(N)에 풀어야 할 듯

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, l, count = 0;
    stringstream ss;
    cin >> n >> l;
    vector<pair<int, int>> array(n); // {input, index}
    vector<int> output(n, -1);
    for (int i = 0; i < n; i++) {
        cin >> array[i].first;
        array[i].second = i;
    }
    auto comp = [] (pair<int, int> a, pair<int, int> b) {
        return a.first > b.first;
    };
    priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(comp)> minHeap(comp);
    for (int i = 0; i < n; ++i) {
        minHeap.emplace(array[i]);
        while(minHeap.top().second < i - l + 1) {
            minHeap.pop();
        }
        ss << minHeap.top().first << ' ';
    }
    cout << ss.str();
}