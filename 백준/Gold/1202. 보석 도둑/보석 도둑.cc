#include <bits/stdc++.h>
using namespace std;

pair<int, int> jewels[300002]; // 가치, 무게
multiset<int> bags;

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    
    int n, k; cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> jewels[i].second >> jewels[i].first;
    }

    for (int i = 0; i < k; i++) {
        int w; cin >> w;
        bags.insert(w);
    }

    sort(jewels, jewels + n);
    long long sum = 0;

    for (int i = n - 1; i >= 0; i--) {
        auto targetIt = bags.lower_bound(jewels[i].second);
        if (targetIt == bags.end()) continue;
        sum += jewels[i].first;
        bags.erase(targetIt);
    }
    cout << sum;
}