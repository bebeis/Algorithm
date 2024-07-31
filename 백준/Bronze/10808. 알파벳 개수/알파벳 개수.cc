#include <bits/stdc++.h>
using namespace std;

int arr[26];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    string s;
    cin >> s;
    for (auto it : s) {
        arr[(it - 'a')]++;
    }
    for (auto it : arr) {
        cout << it << " ";
    }
}