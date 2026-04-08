/**
 * 자기가 같이 하고 싶어하는 팀원 선택 (자기 자신도 가능)
 * - O(nlogn) 이하로 풀이
 * - 탐색을 하다 순환 고리가 만들어지면, 해당 인원들은 팀, 고리 밖은 솔로
 * 핵심은 한 번 방문한 사람을 다음 루프에서 또 방문하지 않도록 하는 것, 즉 O(n^2)을 방지한다.
 * 
 * 탐색을 멈추는 이유
 * - 이미 계산된 사람을 만남 -> 해당 경로의 모든 사람은 팀을 못맺음
 * - 순환 고리를 찾음 -> 순환 고리끼리는 팀 매칭, 나머지는 팀 못맺음
 */

#include <bits/stdc++.h>
using namespace std;

int arr[100002];

void solve() {
    int n; cin >> n;
    for (int i = 1; i <= n; i++) cin >> arr[i];
    vector<bool> fixed(n + 1);
    vector<bool> matched(n + 1);
    
    for (int i = 1; i <= n; i++) {
        if (fixed[i]) continue;

        unordered_set<int> us;
        us.insert(i);
        int nxt = arr[i];
        
        while (us.find(nxt) == us.end() && !fixed[nxt]) {
            us.insert(nxt);
            nxt = arr[nxt];
        }

        // 이미 계산된 사람을 만난 경우
        if (fixed[nxt]) {
            for (auto x : us) {
                fixed[x] = true;
            }
            continue;
        }

        // 사이클을 찾은 경우
        int st = nxt;
        matched[st] = true;
        fixed[st] = true;
        nxt = arr[nxt];

        while (nxt != st) {
            matched[nxt] = true;
            // fixed[nxt] = true;
            nxt = arr[nxt];
        }

        for (auto x : us) fixed[x] = true;
    }

    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        if (!matched[i]) cnt++;
    }
    cout << cnt << '\n';
}

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    int t; cin >> t;

    while (t-- > 0) {
        solve();
    }
}