#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int pos = -1, piece = 0;
    string input;
    cin >> input;
    stack<pair<char, int>> bracket;
    for (char& c : input) {
        if (c == '(') {
            bracket.push({c, ++pos});
        } else if (bracket.top().second == pos){ // razer
            bracket.pop();
            piece += bracket.size();
        } else { // bar
            bracket.pop();
            piece++;
        }
    }
    cout << piece;
}