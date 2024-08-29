#include <bits/stdc++.h>
using namespace std;

int t;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> t;
    while (t--) {
        multiset<int> ms;
        int k;
        cin >> k;
        while (k--) {
            char inst;
            int val;
            cin >> inst >> val;
            if (inst == 'I') ms.insert(val);
            else if (!ms.empty()) {
                if (val == 1) ms.erase(prev(ms.end()));
                else ms.erase(ms.begin());
            }
        }
        if (ms.empty()) cout << "EMPTY\n";
        else cout << *prev(ms.end()) << " " << *ms.begin() << '\n';
        
    }
}