#include <bits/stdc++.h>
using namespace std;

// n <= 1 000 000
// O(nlogn) 이하로 풀이
// 데이터의 삽입 삭제가 빈번
// 데이터가 중간에 삽입되어야 한다 -> 연결리스트 사용하는게 유리

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);

    int t; cin >> t;
    while (t--) {
        list<char> form;
        string input;
        cin >> input;
        auto it = form.begin();
        for (char c : input) {
            if (c == '<') {
                if (distance(it, form.begin()) == 0) continue;
                it--;
            } else if (c == '>') {
                if (distance(it, form.end()) == 0) continue;
                it++;
            } else if (c == '-') {
                if (distance(it, form.begin()) == 0) continue;
                it = form.erase(--it);
            } else {
                form.insert(it, c);
            }
        }
        for (auto c : form) {
            cout << c;
        }
        cout << '\n';
    }
}