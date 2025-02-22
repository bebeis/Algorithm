#include <bits/stdc++.h>
using namespace std;

unordered_map<string, int> s2i;
priority_queue<int, vector<int>> pq[100002];
int id = 0;
long long ans = 0;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int Q; cin >> Q;
    while (Q--) {
        int query; cin >> query;
        if (query == 1) {
            string name; int n;
            cin >> name >> n;
            int curId;
            if (s2i.find(name) == s2i.end()) {
                curId = ++id;
                s2i[name] = curId;
            } else {
                curId = s2i[name];
            }
            while (n--) {
                int x; cin >> x;
                pq[curId].push(x);
            }
        } else {
            string name; int n;
            cin >> name >> n;
            if (s2i.find(name) == s2i.end()) continue;
            auto& curPQ = pq[s2i[name]];
            while (!curPQ.empty() && n > 0) {
                ans += curPQ.top();
                curPQ.pop();
                n--;
            }
        }
    }
    cout << ans;
}