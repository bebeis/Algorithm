#include <bits/stdc++.h>
using namespace std;

// 고점에 도달했을 때는 반드시 팔아야 한다.
// O(N^2)으로 풀면 안되는데, 문제 조건을 안읽고 풀어서 WA

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int t; cin >> t;
    while (t--) {
        int n; cin >> n;
        vector<int> price(n);
        long long earn = 0;
        
        for (int i = 0; i < n; i++) cin >> price[i];
        // 앞에서부터 매번 맨 뒤까지 부분 최댓값을 찾으면서 순회하면 O(N^2) --> 비효율적
        int j = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (price[i] < price[j]) earn += price[j] - price[i];
            else j = i; // 최댓값 수정
        }
        cout << earn << '\n';
    }
}