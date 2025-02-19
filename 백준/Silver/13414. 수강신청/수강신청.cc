#include <bits/stdc++.h>
using namespace std;

unordered_map<string, int> s2i;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int k, l; cin >> k >> l;
    for (int i = 1; i <= l; i++) {
        string s; cin >> s;
        s2i[s] = i;
    }

    vector<pair<string, int>> lists(s2i.begin(), s2i.end());
    sort(lists.begin(), lists.end(), [](pair<string, int> p1, pair<string, int> p2) {
        return p1.second < p2.second;
    });

    for (int i = 0; i < k && i < lists.size(); i++) {
        cout << lists[i].first << '\n';
    }

}