#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);
    int n; cin >> n;

    vector<string> words;
    for (int i = 0; i < n; i++) {
        string s; cin >> s;
        words.push_back(s);
    }

    sort(words.begin(), words.end(), [](const auto& s1, const auto& s2) {
        if (s1.length() != s2.length()) return s1.length() < s2.length();
        int sum1 = 0; int sum2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (isdigit(s1[i])) sum1 += (s1[i] - '0');
            if (isdigit(s2[i])) sum2 += (s2[i] - '0');
        }

        if (sum1 != sum2) return sum1 < sum2;
        return s1 < s2;
    });

    for (auto& word : words) {
        cout << word << '\n';
    }
}