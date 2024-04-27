#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool comp(pair<string, int> a, pair<string, int> b) {
    if (a.second > b.second) {
        return true;
    }
    else if (a.second == b.second) {
        if (a.first.length() > b.first.length()) {
            return true;
        }
        else if (a.first.length() == b.first.length()) {
            for (int i = 0; i < a.first.length(); i++) {
                if (a.first[i] < b.first[i]) {
                    return true;
                }
                else if (a.first[i] == b.first[i]) {
                    continue;
                }
                else {
                    return false;
                }
            }
            return false;
        }
        else {
            return false;
        }
    }
    else {
        return false;
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m;
    string temp;
    unordered_map<string, int> words;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> temp;
        if (temp.length() >= m) {
            if (words.count(temp)) {
                words[temp] = words[temp] + 1;
            }
            else {
                words[temp] = 1;
            }
        }
    }
    vector<pair<string, int>> wordArray(words.begin(), words.end());
    sort(wordArray.begin(), wordArray.end(), comp);
    for (auto& data : wordArray) {
        cout << data.first << '\n';
    }
}