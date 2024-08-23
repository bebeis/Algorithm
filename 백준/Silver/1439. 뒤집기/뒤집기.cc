#include <bits/stdc++.h>
using namespace std;

string s;
int result = 0;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> s;
    for (int i = 0;i < s.length(); i++) 
        if (s[i] != s[i + 1]) result++;
    if (!result) cout << result;
    else cout << result / 2;
}