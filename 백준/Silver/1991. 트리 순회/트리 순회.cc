#include <bits/stdc++.h>
using namespace std;

int lc[28];
int rc[28];

void pre(int cur) {
    cout << (char)(cur + 'A');
    if (lc[cur] != 0) pre(lc[cur]);
    if (rc[cur] != 0) pre(rc[cur]);
}

void inorder(int cur) {
    if (lc[cur] != 0) inorder(lc[cur]);
    cout << (char)(cur + 'A');
    if (rc[cur] != 0) inorder(rc[cur]);
}

void post(int cur) {
    if (lc[cur] != 0) post(lc[cur]);
    if (rc[cur] != 0) post(rc[cur]);
    cout << (char)(cur + 'A');
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        char cur, left, right;
        cin >> cur >> left >> right;
        if (left != '.') lc[cur - 'A'] = left - 'A';
        if (right != '.') rc[cur - 'A'] = right - 'A';
    }
    pre(0); cout << '\n';
    inorder(0); cout << '\n';
    post(0); cout << '\n';
}