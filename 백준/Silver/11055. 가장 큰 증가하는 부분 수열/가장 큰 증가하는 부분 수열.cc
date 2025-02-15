#include <bits/stdc++.h>
using namespace std;
// 펜윅트리(BIT) 풀이
// 수열의 범위가 1000이라서 가능한 풀이
// 만약 1억이 넘는다면 BIT를 못쓴다.
const int MAX_A = 1001;


int query(vector<int>& BIT, int idx) {
    int res = 0;
    while(idx > 0) {
        res = max(res, BIT[idx]);
        idx -= (idx & -idx);
    }
    return res;
}

void update(vector<int>& BIT, int idx, int val) {
    while(idx < MAX_A) {
        BIT[idx] = max(BIT[idx], val);
        idx += (idx & -idx);
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int n;
    cin >> n;
    
    vector<int> A(n);
    for (int i = 0; i < n; i++){
        cin >> A[i];
    }
    
    // BIT 배열 초기화 (1-indexed)
    vector<int> BIT(MAX_A, 0);
    int answer = 0;
    
    for (int i = 0; i < n; i++){
        // A[i]보다 작은 수들의 dp값의 최댓값을 구함.
        int best = query(BIT, A[i] - 1) + A[i];
        update(BIT, A[i], best);
        answer = max(answer, best);
    }
    
    cout << answer << "\n";
}
