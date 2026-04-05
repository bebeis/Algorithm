/**
 * O(1) 시간에 해결해야 함
 * - 매 상태를 순회하면서 계산하는 건 불가능함
 * - 특정한 상태를 유지하면서 순회해야 함. 
 * - 앞으로의 상태에서 원하는 목표를 얻기 위한 불필요한 정보는 버려야 함
 * 
 * - front에 최솟값을 둔다고 해보자. O(1)에 조회 가능하다.
 * 1. 해당 값보다 큰 값은 자료구조 내에서 유지될 필요가 없음 -> 전부 제거
 * 2. 뒤에서 push, 맨 앞은 최솟값
 * - 앞으로 오는 값이 front보다 작다면, 기존 front는 이제 사용되지 않는 값이다 -> 버림
 * - 앞으로 오는 값이 front보다 크다면, 해당 값보다 큰 값은 자료구조 내에서 유지될 필요가 없음
 */

// 1 5 2 3 6 2 3 7 3 5 2 6
// 1 

#include <bits/stdc++.h>
using namespace std;

int arr[5000002];

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    int n, l; cin >> n >> l;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    deque<int> dq;
    for (int i = 0; i < n; i++) {
        while (!dq.empty() && dq.back() > arr[i]) {
            dq.pop_back();
        }

        dq.push_back(arr[i]);
        cout << dq.front() << " ";

        int lastIdx = i - l + 1;
        if (lastIdx < 0) continue;
        if (arr[lastIdx] == dq.front()) dq.pop_front();
    }
}