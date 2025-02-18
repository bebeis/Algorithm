#include <bits/stdc++.h>
using namespace std;

int n;
unordered_set<string> us;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    while (n--) {
        string name, status;
        cin >> name >> status;
        if (status == "enter") {
            us.insert(name);
        } else {
            us.erase(name);
        }
    }
    vector<string> ans(us.begin(), us.end());
    sort(ans.begin(), ans.end(), greater<string>());
    for (string s : ans) cout << s << '\n';
}