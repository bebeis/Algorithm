#include <bits/stdc++.h>
using namespace std;

int n, m;
unordered_map<string, int> umsi;
string names[100002];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        string s; cin >> s;
        umsi[s] = i;
        names[i] = s;
    }
    while (m--) {
        string nameOrInteger;
        cin >> nameOrInteger;
        if (isdigit(nameOrInteger[0])) {
            cout << names[stoi(nameOrInteger)] << '\n';
        } else {
            cout << umsi[nameOrInteger] << '\n';
        }
    }
}