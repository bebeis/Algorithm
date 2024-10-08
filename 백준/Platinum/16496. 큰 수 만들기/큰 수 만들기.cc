#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
        
    int n;
    cin >> n;
    vector<string> val(n);
    for(int i = 0; i < n; i++) {
        cin >> val[i];
    }

    // a + b > b + a 인 경우 a가 먼저 오도록 정렬
    sort(val.begin(), val.end(), [&](const string &a, const string &b) -> bool {
        return a + b > b + a;
    });

    if(val[0] == "0") {
        cout << "0";
        return 0;
    }

    string result = "";
    for(auto &s : val) {
        result += s;
    }
    cout << result;
}
