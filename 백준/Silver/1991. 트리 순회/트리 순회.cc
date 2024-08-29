#include <bits/stdc++.h>
using namespace std;

vector<int> adj[27];
char lc[27];
char rc[27];
int n;

void PreOrder(char cur) {
    cout << cur;
    if (lc[cur - 64] != 0) PreOrder(lc[cur - 64]);
    if (rc[cur - 64] != 0) PreOrder(rc[cur - 64]);
}

void InOrder(char cur) {
    if (lc[cur - 64] != 0) InOrder(lc[cur - 64]);
    cout << cur;
    if (rc[cur - 64] != 0) InOrder(rc[cur - 64]);
}

void PostOrder(char cur) {
    if (lc[cur - 64] != 0) PostOrder(lc[cur - 64]);
    if (rc[cur - 64] != 0) PostOrder(rc[cur - 64]);
    cout << cur;
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        char parent, l, r;
        cin >> parent >> l >> r;
        if (l != '.') lc[parent - 64] = l;
        if (r != '.') rc[parent - 64] = r;
    }
    PreOrder('A');
    cout << '\n';
    InOrder('A');
    cout << '\n';
    PostOrder('A');
}