#include <bits/stdc++.h>
using namespace std;

int a;
string b;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> a >> b;
    cout << a * (b[2] - '0') << '\n';
    cout << a * (b[1] - '0') << '\n';
    cout << a * (b[0] - '0') << '\n';
    cout << a * stoi(b);
}