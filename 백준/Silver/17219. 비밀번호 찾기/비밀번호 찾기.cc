#include <bits/stdc++.h>
using namespace std;

unordered_map<string, string> s2s;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int n, m; cin >> n >> m;
    for (int i = 0; i < n; i++) {
        string domain, pw; cin >> domain >> pw;
        s2s[domain] = pw;
    } 
    while (m--) {
        string domain; cin >> domain;
        cout << s2s[domain] << '\n';
    }
}