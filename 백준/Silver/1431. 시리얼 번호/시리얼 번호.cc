#include <bits/stdc++.h>
using namespace std;

string arr[52];
int n;

bool cmp(string a, string b) {
    if (a.length() < b.length()) return true;
    else if (a.length() == b.length()) {
        int aSum = 0;
        int bSum = 0;
        for (char c : a) {
            if (isdigit(c)) aSum += (c - '0');
        }
        for (char c : b) {
            if (isdigit(c)) bSum += (c - '0');
        }
        if (aSum < bSum) return true;
        else if (aSum == bSum) {
            return a < b;
        }
        else {
            return false;
        }
    } else {
        return false;
    }
    return false;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n, cmp);
    for (int i = 0; i < n; i++) cout << arr[i] << '\n';
}