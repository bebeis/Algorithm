#include <bits/stdc++.h>
using namespace std;

// time limit : 1s, input : 100,100 --> O(Nlogn) 이하로 해결
// 무지성으로 reverse를 했더니 시간초과 발생 O(N) --> reverse iterator사용
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t, n;
    cin >> t;
    while (t--) {
        string function, arrayString;
        bool rvs = false, error = false;
        deque<int> deq;
        cin >> function;
        cin >> n;
        cin >> arrayString;
        string s = "";
        for (int i = 0; i < arrayString.length(); i++) {
            if (isdigit(arrayString[i])) {
                s += arrayString[i];
            } else {
                if (!s.empty()) {
                    deq.push_back(stoi(s));
                    s = "";
                }
            }
        }
        for (auto o : function) {
            if (o == 'R') {
                rvs = !rvs;
            } else {
                if (deq.empty()) {
                    cout << "error" << '\n';
                    error = true;
                    break;
                }
                if (rvs)
                    deq.pop_back();
                else
                    deq.pop_front();
            }
        }
        if (!error) {
            cout << '[';
        }
        if (rvs && !deq.empty()) {
            for (auto iter = deq.rbegin(); iter != deq.rend(); iter++) {
                if (iter == deq.rend() - 1)
                    cout << *iter;
                else
                    cout << *iter << ',';
            }
        } else if (!rvs && !deq.empty()) {
            for (auto iter = deq.begin(); iter != deq.end(); iter++) {
                if (iter == deq.end() - 1)
                    cout << *iter;
                else
                    cout << *iter << ',';
            }
        }
        if (!error)
            cout << "]\n";
    }
}