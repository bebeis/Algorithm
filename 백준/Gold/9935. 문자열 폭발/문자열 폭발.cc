#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    string str, bomb;
    stack<pair<int, int>> S;
    int bomb_idx = 0;
    unordered_set<int> ns;
    cin >> str >> bomb;

    for (int idx = 0; idx < str.length(); idx++) {
        if (str[idx] != bomb[bomb_idx]) {
            bomb_idx = 0;
        }
        if (str[idx] == bomb[bomb_idx]) {
            S.push({idx, bomb_idx});
            if (bomb_idx == bomb.length() - 1) { // 문자열 포함
                for (int i = 0; i < bomb.length(); i++) {
                    ns.insert(S.top().first);
                    S.pop();
                }
                if (S.empty()) bomb_idx = -1;
                else bomb_idx = S.top().second;
            }
            bomb_idx++;
        } else {
            S = stack<pair<int, int>>();
        }
    }

    if (ns.size() == str.size()) cout << "FRULA";
    else {
        for (int i = 0; i < str.length(); i++) {
            if (!ns.contains(i)) cout << str[i];
        }
    }
}