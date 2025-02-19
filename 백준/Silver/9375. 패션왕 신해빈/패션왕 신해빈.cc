#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int t; cin >> t;
    while (t--) {
        unordered_map<string, int> s2i;
        int n; cin >> n;
        for (int i = 0; i < n; i++) {
            string category, name;
            cin >> name >> category;
            if (s2i.find(category) == s2i.end()) {
                s2i[category] = 1;
            } else {
                s2i[category]++;
            }
        }
        int allCase = 1;
        for (auto category: s2i) {
            allCase *= (category.second + 1);
        }
        cout << allCase - 1 << '\n';

    }
}