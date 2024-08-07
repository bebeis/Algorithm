#include <bits/stdc++.h>
using namespace std;

// O(nlogn) 이하로 풀이해야 함
// input을 받자 마자 pq에 넣는게 아니라 input을 먼저 정렬한 후 pq에 넣었어야 했는데 요거때문에 2트

pair<int, int> arr[200005];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    priority_queue<int, vector<int>, greater<int>> pq;
    int n, cnt = 0;
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i].first >> arr[i].second;
    sort(arr, arr + n);
    pq.push(arr[0].second);
    for (int i = 1; i < n; i++) {
        auto [s, e] = arr[i];
        if (pq.top() <= s) pq.pop();
        pq.push(e);
    }
    cout << pq.size();
}